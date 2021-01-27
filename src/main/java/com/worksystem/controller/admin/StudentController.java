package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Student;
import com.worksystem.service.GradeService;
import com.worksystem.service.StudentService;
import com.worksystem.utils.HTMLUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class StudentController {

    private final StudentService studentService;

    private final GradeService gradeService;

    @Autowired
    public StudentController(StudentService studentService, GradeService gradeService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
    }

    @PostMapping("/studentAdd")
    public String studentAdd(ModelMap modelMap, MultipartFile excelFile, Integer sgid, Student student) {
        /*
         判断是否有excel文档上传
        如果有，则执行批量添加（伪）
        如果没有，则执行单条添加
         */
        if (excelFile != null && !excelFile.isEmpty()) {
            // 声明操作excel的类
            HSSFWorkbook excel;
            HSSFSheet sheet0;
            try {
                // 获取excel文档
                excel = new HSSFWorkbook(excelFile.getInputStream());
                // 获取第一个sheet
                sheet0 = excel.getSheetAt(0);
                // 创建学号和姓名集合
                List<String> numbers = new ArrayList<>();
                List<String> names = new ArrayList<>();
                // 循环读取sheet并添加到集合中
                for (Row row : sheet0) {
                    // 跳过第一行
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    numbers.add(row.getCell(0).getStringCellValue());
                    names.add(row.getCell(1).getStringCellValue());
                }

                // 创建学生集合
                List<Student> students = new ArrayList<>();
                for (int i = 0; i < numbers.size(); i++) {
                    Student addStudent = new Student();
                    addStudent.setSnumber(numbers.get(i));
                    addStudent.setSpwd("123456");
                    addStudent.setSname(names.get(i));
                    addStudent.setSgid(sgid.toString());
                    // 连接数据库进行添加
                    students.add(addStudent);
                }

                // 连接数据库，添加学生
                int result = studentService.insertBatch(students);

                // 判断是否成功
                if (result >= numbers.size()) {
                    return HTMLUtils.success(modelMap, "批量添加成功！", "form");
                } else {
                    return HTMLUtils.error(modelMap, "批量添加失败！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 数据判断
            if (student.getSnumber().isEmpty()) {
                return HTMLUtils.error(modelMap, "学号不能为空！");
            }
            if (student.getSpwd().isEmpty()) {
                return HTMLUtils.error(modelMap, "密码不能为空！");
            }
            if (student.getSname().isEmpty()) {
                return HTMLUtils.error(modelMap, "姓名不能为空！");
            }
            if (student.getSgid().isEmpty()) {
                return HTMLUtils.error(modelMap, "班级不能为空！");
            }

            // 连接数据库，插入数据
            int result = studentService.insert(student);

            // 判断是否成功
            if (result > 0) {
                return HTMLUtils.success(modelMap, "添加学生成功！", "form");
            } else {
                return HTMLUtils.error(modelMap, "添加学生失败！");
            }
        }
        return "";
    }

    @GetMapping("/studentList")
    public String studentList(Integer gid, ModelMap modelMap) {
        if (gid == null) {
            // 连接数据库，获取数据并跳转
            modelMap.addAttribute("students", studentService.selectAndGname());
        } else {
            // 连接数据库，获取数据并跳转
            modelMap.addAttribute("students", studentService.selectAndGname(gid));
        }
        // 这个页面不需要重定向到其他控制器，因为直接转发到相应jsp页面
        return "admin/student";
    }

    @GetMapping("/studentModify")
    public String getStudentModify(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin, Student student) {
        // 连接数据库，获取要修改的学生的信息
        modelMap.addAttribute("student", studentService.selectByPrimaryKey(student.getSid()));
        // 连接数据库，获取班级信息
        if (admin.getAgid() == 0) {
            modelMap.addAttribute("grades", gradeService.selectAll());
        } else {
            modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(Integer.valueOf(student.getSgid())));
        }
        return "/admin/studentModify";
    }

    @PostMapping("/studentModify")
    public String postStudentModify(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin, Student student) {
        //数据判断
        if(student.getSnumber().isEmpty()) {
            HTMLUtils.error(modelMap, "学号不能为空！");
        }
        if(student.getSpwd().isEmpty()) {
            HTMLUtils.error(modelMap, "密码不能为空！");
        }
        if(student.getSname().isEmpty()) {
            HTMLUtils.error(modelMap, "姓名不能为空！");
        }

        //连接数据库更改数据
        int result = studentService.updateByPrimaryKey(student);

        // 判断是否成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "更改成功！", "studentList?gid="+admin.getAgid());
        } else {
            return HTMLUtils.error(modelMap, "更改失败！");
        }
    }

    @GetMapping("/studentDelete")
    public String studentDelete(ModelMap modelMap, Integer sid) {
        // 连接数据库，删除
        int result = studentService.deleteByPrimaryKey(sid);
        // 判断是否成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "删除成功！", "studentList");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }
}
