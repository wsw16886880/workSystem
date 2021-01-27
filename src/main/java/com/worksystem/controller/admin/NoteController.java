package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Note;
import com.worksystem.service.NoteService;
import com.worksystem.service.SubjectService;
import com.worksystem.service.WorkService;
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
public class NoteController {

    private final NoteService noteService;

    private final WorkService workService;

    private final SubjectService subjectService;

    @Autowired
    public NoteController(NoteService noteService, WorkService workService, SubjectService subjectService) {
        this.noteService = noteService;
        this.workService = workService;
        this.subjectService = subjectService;
    }

    @PostMapping("/noteAdd")
    public String noteAdd(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin, Note note) {
        // 数据判断
        if (note.getNtitle().isEmpty()) {
           return HTMLUtils.error(modelMap, "标题不能为空！");
        }
        if (note.getNweek() == 0) {
           return HTMLUtils.error(modelMap, "周数不能为空！");
        }
        if (note.getNfrom().isEmpty()) {
            return HTMLUtils.error(modelMap, "来源不能为空！");
        }
        if (note.getNcontent().isEmpty()) {
            return HTMLUtils.error(modelMap, "内容不能为空！");
        }

        // 封装数据，添加时间
        note.setNdate(new Date(System.currentTimeMillis()));

        // 连接数据库，添加笔记
        int result = noteService.insertSelective(note);

        // 判断是否修改成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "添加失败！");
        }
    }

    @GetMapping("/noteList")
    public String noteList(ModelMap modelMap) {
        // 连接数据库查询数据
        modelMap.addAttribute("notes",noteService.selectMoreTable());
        return "/admin/note";
    }

    @GetMapping("/noteModify")
    public String noteModify(ModelMap modelMap, Integer nid) {
        // 判断数据
        if (nid == 0) {
            return HTMLUtils.error(modelMap, "id出错！");
        }

        //获取数据，保存到modelMap
        modelMap.addAttribute("note", noteService.selectByPrimaryKey(nid));
        modelMap.addAttribute("works", workService.selectAllFewTable());
        modelMap.addAttribute("subjects", subjectService.selectAll());

        return "/admin/noteModify";
    }

    @PostMapping("/noteModify")
    public String noteModify(ModelMap modelMap, Note note){

        // 数据判断
        if (note.getNtitle() == null || note.getNtitle().isEmpty()) {
            return HTMLUtils.error(modelMap, "标题不能为空！");
        }
        if (note.getNweek() == null || note.getNweek() == 0) {
            return HTMLUtils.error(modelMap, "周数不能为空！");
        }
        if (note.getNfrom() == null || note.getNfrom().isEmpty()) {
            return HTMLUtils.error(modelMap, "来源不能为空！");
        }
        if (note.getNcontent() == null || note.getNcontent().isEmpty()) {
            return HTMLUtils.error(modelMap, "内容不能为空！");
        }

        //连接数据库，修改数据
        int result = noteService.updateByPrimaryKey(note);
        // 判断是否修改成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "修改成功！", "noteList");
        } else {
            return HTMLUtils.error(modelMap, "修改失败！");
        }
    }

    @GetMapping("/noteDelet")
    public String noteDelet(ModelMap modelMap, Integer nid) {
        //判断数据
        if(nid == 0) {
           return HTMLUtils.error(modelMap, "id出错！");
        }

        //连接数据库，删除数据
        int result = noteService.deleteByPrimaryKey(nid);

        // 判断是否修改成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "添加失败！");
        }
    }
}
