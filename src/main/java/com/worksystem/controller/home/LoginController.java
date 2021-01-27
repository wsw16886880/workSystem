package com.worksystem.controller.home;

import com.alibaba.fastjson.JSON;
import com.worksystem.entity.Grade;
import com.worksystem.entity.JsonResult;
import com.worksystem.entity.Student;
import com.worksystem.entity.WXCode2Session;
import com.worksystem.exception.StudentRuntimeException;
import com.worksystem.service.GradeService;
import com.worksystem.service.StudentService;
import com.worksystem.utils.CookieUtils;
import com.worksystem.utils.HttpsRequestUtil;
import com.worksystem.utils.JsUtils;
import com.worksystem.utils.ServletUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author wsw16
 */
@Controller
//@SessionAttributes(value = {"token", "sid"})
class LoginController {

    private final StudentService studentService;

    private final GradeService gradeService;

    public LoginController(StudentService studentService, GradeService gradeService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
    }

    @GetMapping("/outLogin")
    public String outLogin(HttpServletRequest request, HttpServletResponse response) {
        // 清除cookie
        CookieUtils.clear(response, request);
        return "redirect:/login";
    }

    /**
     * 微信登录
     */
    @GetMapping("/wxlogin")
    @ResponseBody
    public JsonResult wxLogin(String code, HttpSession session) {
        JsonResult jsonResult = new JsonResult();
        // 判断该微信是否绑定了学号，如果没有绑定，需要先登录账号（通过sid判断是否登录了学号）
        String appid = "wx5b892277a6d2ab02";
        String appsecret = "d55b2271784ab75e344f1ec0f13c4aa9";
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + appid
                + "&secret="
                + appsecret
                + "&js_code="
                + code
                + "&grant_type=authorization_code";
        try {
            // 请求微信服务器核对微信账号
            String result = HttpsRequestUtil.HttpsRequest(requestUrl, "GET",
                    null);
            // 将从微信服务器获取到的信息转换为实体类
            WXCode2Session wxCode2Session = JSON.parseObject(result, WXCode2Session.class);
            // 判断是否成功
            if (wxCode2Session.getErrcode() == 0) {
                // 登录成功
                // 判断该微信是否绑定了学号
                List<Student> students = studentService.checkWXBindNumber(wxCode2Session.getOpenid());
                if (students.size() > 0) {
                    // 已绑定
                    // 获取sid，和token一起存储到session中
                    Integer sid = students.get(0).getSid();
                    String token = UUID.randomUUID().toString();
                    session.setAttribute("sid", sid);
                    session.setAttribute("token", token);

                    // 获取个人信息
                    Student student = students.get(0);
                    Grade grade = gradeService.selectByPrimaryKey(Integer.valueOf(student.getSgid()));
                    Student mStudent = new Student();
                    mStudent.setSname(student.getSname());
                    mStudent.setSnumber(student.getSnumber());
                    mStudent.setSgid(student.getSgid());
                    mStudent.setSid(student.getSid());

                    // 设置返回的json
                    jsonResult.setCode(0);
                    Map<String, Object> map = new HashMap<>(2);
                    map.put("token", token);
                    map.put("sessionId", session.getId());
                    map.put("grade", grade);
                    map.put("student", mStudent);
                    jsonResult.setData(map);
                } else {
                    // 未绑定
                    // 查看是否已经使用学号登录
                    Integer sid = session.getAttribute("sid") != null ? Integer.valueOf(session.getAttribute(
                            "sid").toString()) : null;
                    if (sid != null) {
                        // 已使用学号登录
                        // 获取学生信息
                        Student student = studentService.selectByPrimaryKey(sid);
                        // 添加openId和sessionKey到学生信息中
                        student.setOpenid(wxCode2Session.getOpenid());
                        student.setSessionKey(wxCode2Session.getSession_key());
                        // 修改学生信息
                        studentService.updateByPrimaryKey(student);

                        // 获取个人信息
                        Grade grade = gradeService.selectByPrimaryKey(Integer.valueOf(student.getSgid()));
                        Student mStudent = new Student();
                        mStudent.setSname(student.getSname());
                        mStudent.setSnumber(student.getSnumber());
                        mStudent.setSgid(student.getSgid());
                        mStudent.setSid(student.getSid());

                        // 将sid和token一起存储到session中
                        String token = UUID.randomUUID().toString();
                        session.setAttribute("sid", sid);
                        session.setAttribute("token", token);

                        // 设置返回的json
                        jsonResult.setCode(0);
                        Map<String, Object> map = new HashMap<>(2);
                        map.put("token", token);
                        map.put("sessionId", session.getId());
                        map.put("grade", grade);
                        map.put("student", mStudent);
                        jsonResult.setData(map);
                    } else {
                        // 未使用学号登录
                        jsonResult.setCode(-10086);
                        jsonResult.setMessage("请先使用学号登录！");
                    }
                }
            } else {
                // 登录失败
                jsonResult.setCode(wxCode2Session.getErrcode());
                jsonResult.setMessage(wxCode2Session.getErrmsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 输出数据
        return jsonResult;
    }

    /**
     * 学号登录
     * 错误码：-1.普通错误
     * -10080.没有绑定微信，需要绑定微信
     */
    @PostMapping("/wxlogin")
    @ResponseBody
    public JsonResult wxNumberLogin(Student student, HttpSession session) {
        JsonResult jsonResult = new JsonResult();
        // 学号登录
        String regex = "^-?[1-9]\\d*$";
        if (student.getSnumber() == null) {
            jsonResult.setCode(-1);
            jsonResult.setMessage("学号不能为空");
            return jsonResult;
        } else if (student.getSpwd() == null) {
            jsonResult.setCode(-1);
            jsonResult.setMessage("密码不能为空");
            return jsonResult;
        } else if (!student.getSnumber().matches(regex)) {
            jsonResult.setCode(-1);
            jsonResult.setMessage("学号只能为数字");
            return jsonResult;
        }

        try {
            // 连接数据库，登录账号，获取student
            student = studentService.login(student);

            // 保存sid到session中
            session.setAttribute("sid", student.getSid());

            // 判断学号是否与微信绑定，如果没有绑定，则提醒绑定
            Map<String, Object> map = new HashMap<>(2);

            if (student.getOpenid() != null && !student.getOpenid().isEmpty()) {
                // 已绑定
                // 生成token
                String token = UUID.randomUUID().toString();
                // 将token保存到session中
                session.setAttribute("token", token);

                // 获取个人信息：班级信息
                Grade grade = gradeService.selectByPrimaryKey(Integer.valueOf(student.getSgid()));
                Student mStudent = new Student();
                mStudent.setSname(student.getSname());
                mStudent.setSnumber(student.getSnumber());
                mStudent.setSgid(student.getSgid());
                mStudent.setSid(student.getSid());
                // 保存token和sessionId
                map.put("token", token);
                map.put("sessionId", session.getId());
                map.put("grade", grade);
                map.put("student", mStudent);
                // 生成成功数据返回小程序
                jsonResult.setCode(0);
                jsonResult.setData(map);
            } else {
                // 未绑定
                // 未绑定的token需要绑定之后才生成token
                // 保存sessionId
                map.put("sessionId", session.getId());
                jsonResult.setCode(-10080);
                jsonResult.setData(map);
                jsonResult.setMessage("该学号未绑定微信，请按【确认】按钮绑定微信");
            }

        } catch (StudentRuntimeException e) {
            jsonResult.setCode(-1);
            jsonResult.setMessage(e.getMessage());
        }

        return jsonResult;
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(ModelMap modelMap, HttpServletResponse response, Student student) {
        // 数据判断
        if (student.getSnumber() == null) {
            return ServletUtils.transpond(modelMap, "/login", "sn", "学号不能为空！");
        }
        // 正则：判断是否包含非数字字符
        String regex = "\\D+";
        if (student.getSnumber().matches(regex)) {
            return ServletUtils.transpond(modelMap, "/login", "sn", "学号只能为数字！");
        }
        if (student.getSpwd() == null) {
            return ServletUtils.transpond(modelMap, "/login", "sp", "密码不能为空！");
        }

        try {
            // 连接数据库，登录账号，获取student
            student = studentService.login(student);
            //保存到cookie
            CookieUtils.addCookie("cksid", String.valueOf(student.getSid()), response);
            CookieUtils.addCookie("cksnumber", student.getSnumber(), response);
            CookieUtils.addCookie("cksname", student.getSname(), response);
            CookieUtils.addCookie("cksgid", String.valueOf(student.getSgid()), response);
            //跳转到/index
            JsUtils.jsGo(response.getWriter(), "登录成功！", "index");
        } catch (StudentRuntimeException e) {
            //login.jsp
            modelMap.addAttribute("StudentRuntimeException", e.getMessage());
            return "/login";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/index";
    }

}
