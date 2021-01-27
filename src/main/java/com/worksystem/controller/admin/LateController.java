package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Late;
import com.worksystem.entity.Teacher;
import com.worksystem.service.GradeService;
import com.worksystem.service.LateService;
import com.worksystem.service.WorkService;
import com.worksystem.utils.DownloadUtils;
import com.worksystem.utils.HTMLUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"admin", "teacher"})
public class LateController {
    private final WorkService workService;

    private final LateService lateService;

    private final GradeService gradeService;

    public LateController(WorkService workService, LateService lateService, GradeService gradeService) {
        this.workService = workService;
        this.lateService = lateService;
        this.gradeService = gradeService;
    }

    @GetMapping("/lateList")
    public String lateList(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin, @SessionAttribute(value = "teacher", required = false) Teacher teacher, Integer wid) {
        List<Late> lates = null;
        if (admin != null) {
            if (admin.getAgid() == 0) {
                lates = lateService.selectAll();
            } else {
                // 判断是否查询单个作业的详情
                if(wid!=null) {
                    lates = lateService.selectByGidAndWid(admin.getAgid(), wid);
                } else {
                    lates = lateService.selectByGid(admin.getAgid());
                }
            }
            modelMap.addAttribute("lates", lates);
            return "/admin/table";
        } else if (teacher != null) {
            // 与sevlet有区别
            lates = lateService.selectByTid(teacher.getTid());
            modelMap.addAttribute("lates", lates);
            return "/admin/teachertable";
        } else {
            return HTMLUtils.error(modelMap, "请登录！", "login");
        }
    }

    @GetMapping("/lateDownload")
    public ResponseEntity<byte[]> lateDownload(ModelMap modelMap, Integer lwid, Integer lweek) throws IOException {
        // 获取去servletContext上下文对象
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        // 设置根路径
        String rootPath = servletContext.getRealPath("/WEB-INF/workfiles") + File.separator + lweek + File.separator + lwid;
        // 连接数据库获取数据
        String lateName = new String();
        List<Late> lates = lateService.selectByWid(lwid);
        List<String> filePaths = new ArrayList<>();
        Map<String, String> fileNames = new HashMap<>();
        Map<String, String> stuNum = new HashMap<>();
        // 遍历已提交的作业的学生的姓名、学号、作业位置
        for (Late late : lates) {
            if (late.getLfile() == null || late.getLfile().isEmpty()) {
                continue;
            }
            if (lateName == null || lateName.isEmpty()) {
                lateName = late.getLname();
            }
            filePaths.add(rootPath + File.separator + late.getLfile());
            fileNames.put(late.getLfile(), late.getLsname());
            stuNum.put(late.getLfile(), late.getLsnumber().substring(10));
        }
        // 设置下载文件显示名称
        StringBuilder echoFilename = new StringBuilder();
        String gname = gradeService.selectByPrimaryKey(workService.selectByPrimaryKey(lwid).getWgid()).getGname();
        echoFilename.append(gname);
        echoFilename.append(lateName);
        echoFilename.append("作业");
        // 创建文件下载工具
        DownloadUtils downloadUtils = new DownloadUtils(servletContext);
        // 获取压缩文件路径
        String zipName = downloadUtils.downloadZip(lates, filePaths, fileNames, stuNum);
        // 创建zip文件对象
        File zipFile = new File(zipName);
        // 创建下载响应头
        HttpHeaders headers = new HttpHeaders();
        // 设置响应方式
        headers.setContentType(MediaType.valueOf(servletContext.getMimeType("work.zip")));
        // 设置响应文件
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(echoFilename.toString() + ".zip", "utf-8"));
        return new ResponseEntity<>(FileUtils.readFileToByteArray(zipFile), headers, HttpStatus.CREATED);
    }
}
