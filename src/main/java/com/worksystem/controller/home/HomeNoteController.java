package com.worksystem.controller.home;

import com.worksystem.entity.JsonResult;
import com.worksystem.entity.Note;
import com.worksystem.service.NoteService;
import com.worksystem.service.SubjectService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/EducationCenter")
public class HomeNoteController {

    private final SubjectService subjectService;

    private final NoteService noteService;

    @Autowired
    public HomeNoteController(NoteService noteService, SubjectService subjectService) {
        this.noteService = noteService;
        this.subjectService = subjectService;
    }

    @GetMapping("/notes")
    @ResponseBody
    public JsonResult appGetNoteList(Integer studyYear, Integer sgid) {
        // 连接数据库获取数据并返回json数据
        List<Map<String, Object>> noteListByGidSemester = noteService.getNoteListByGidSemester(studyYear, sgid);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setData(noteListByGidSemester);
        return jsonResult;
    }

    @GetMapping("/note/{nid}")
    @ResponseBody
    public JsonResult getNote(@PathVariable("nid") Integer nid, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        // 已登录
//        Note note = noteService.selectByPrimaryKey(nid);
        Map<String, Object> note = noteService.selectMoreTableByNid(nid);
        jsonResult.setCode(0);
        jsonResult.setData(note);
        return jsonResult;
    }


    @GetMapping("/noteList")
    public String getNoteList(ModelMap modelMap, @CookieValue("cksgid") Integer gid) {
        // 连接数据库，获取课程名称
        modelMap.addAttribute("subjects", subjectService.selectByGid(gid));
        return "/EducationCenter/Objection";
    }

    @PostMapping("/noteList")
    @ResponseBody
    public List<Note> postNoteList(@CookieValue("cksgid") Integer gid, Integer nsjid, Integer nweek, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 数据判断
        if (nsjid < 0) {
            HTMLUtils.error(request, response, "请选择科目！");
            return null;
        }
        if (nweek != null) {
            List<Map<String, Object>> notes;
            // 连接数据库，获取相应的课程笔记
            // 没有选择周数的情况
            if (nweek < 0) {
                if (nsjid == 0) {
                    // 没有选择具体科目，返回该班级的所有笔记
                    notes = noteService.selectMoreTableBySjgid(gid);
                } else {
                    notes = noteService.selectMoreTableByNsjid(nsjid);
                }
            } else {
                // 选择了课程和周数
                notes = noteService.selectMoreTableByNsjidAndNweek(nsjid, nweek);
            }
            // 保存数据
            request.setAttribute("notes", notes);
            // 重复执行了get方法中的代码，以后想办法优化
            request.setAttribute("subjects", subjectService.selectByGid(gid));
            // 转发
            request.getRequestDispatcher("Objection.jsp")
                    .forward(request, response);
        } else {
            return noteService.selectNweekBySjid(nsjid);
        }
        return null;
    }

    @GetMapping("/note")
    public String noteList(ModelMap modelMap, Integer nid) throws ParseException {
        // 连接数据库，获取数据
        Note note = noteService.selectByPrimaryKey(nid);
        modelMap.addAttribute("note", note);
        modelMap.addAttribute("relate", noteService.relate(note));
        // 转发
        return "/EducationCenter/note";
    }

    @PostMapping("/note")
    @ResponseBody
    public List<Map<String, Object>> note(Integer nsjid, ModelMap modelMap) {
        List<Map<String, Object>> nweeks = noteService.getNweekByNsjid(nsjid);
        return nweeks;
    }
}
