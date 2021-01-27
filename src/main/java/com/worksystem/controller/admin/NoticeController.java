package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Notice;
import com.worksystem.service.GradeService;
import com.worksystem.service.NoticeService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class NoticeController {

    private final NoticeService noticeService;
    private final GradeService gradeService;

    @Autowired
    public NoticeController(NoticeService noticeService, GradeService gradeService) {
        this.noticeService = noticeService;
        this.gradeService = gradeService;
    }

    @PostMapping("/noticeAdd")
    public String noticeAdd(ModelMap modelMap, Notice notice) {
        // 数据判断
        if (notice.getNtitle().isEmpty()) {
            HTMLUtils.error(modelMap, "公告标题不能为空");
        }
        if (notice.getNfrom().isEmpty()) {
            HTMLUtils.error(modelMap, "公告来源不能为空");
        }
        if (notice.getNcontent().isEmpty()) {
            HTMLUtils.error(modelMap, "公告内容不能为空");
        }

        // 封装数据，添加时间
        notice.setNdate(new Date(System.currentTimeMillis()));

        // 连接数据库，添加数据
        int result = noticeService.insertSelective(notice);

        // 判断是否添加成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "添加失败！");
        }
    }

    @GetMapping("/noticeList")
    public String noticeList(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin) {
        if (admin.getAgid() == 0) {
            modelMap.addAttribute("notices", noticeService.selectNoticeAndGrade());
        } else {
            modelMap.addAttribute("notices", noticeService.selectNoticeAndGradeByNgid(admin.getAgid()));
        }
        return "/admin/table";
    }

    @GetMapping("/noticeModify")
    public String noticeModify(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin, Integer nid) {
        // 数据判断
        if (nid == 0) {
            return HTMLUtils.error(modelMap, "nid错误");
        }

        // 获取数据
        if (admin.getAgid() == 0) {
            // 管理员获取所有班级数据
            modelMap.addAttribute("grades", gradeService.selectAll());
        } else {
            // 学委获取自己班级的数据
            modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(admin.getAgid()));
        }
        // 获取公告数据
        modelMap.addAttribute("notice", noticeService.selectByPrimaryKey(nid));
        return "/admin/noticeModify";
    }

    @PostMapping("/noticeModify")
    public String noticeModify(ModelMap modelMap, Notice notice) {
        //数据判断
        if (notice.getNtitle().isEmpty()) {
            return HTMLUtils.error(modelMap, "标题不能为空");
        }
        if (notice.getNfrom().isEmpty()) {
            return HTMLUtils.error(modelMap, "来源不能为空");
        }
        if (notice.getNcontent().isEmpty()) {
            return HTMLUtils.error(modelMap, "内容不能为空");
        }

        // 封装数据，添加时间
        notice.setNdate(new Date(System.currentTimeMillis()));

        // 连接数据库，修改数据
        int result = noticeService.updateByExampleSelective(notice);
        // 判断是否修改成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "更改成功！", "noticeList");
        } else {
            return HTMLUtils.error(modelMap, "更改失败！");
        }

    }

    @GetMapping("/noticeDelete")
    public String noticeDelete(ModelMap modelMap, Integer nid) {
        // 数据判断
        if (nid == 0) {
            return HTMLUtils.error(modelMap, "id出错！");
        }

        // 连接数据库，删除数据
        int result = noticeService.deleteByPrimaryKey(nid);

        // 判断是否删除成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "删除成功！", "noticeList");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }
}
