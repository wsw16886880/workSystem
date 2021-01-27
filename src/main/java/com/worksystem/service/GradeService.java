package com.worksystem.service;

import com.worksystem.entity.*;
import com.worksystem.mapper.GradeMapper;
import com.worksystem.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsw16
 */
@Service
public class GradeService {

    private final GradeMapper gradeMapper;

    private final LateService lateService;

    private final MessageService messageService;

    private final WorkService workService;

    private final NoteService noteService;

    private final NoticeService noticeService;

    private final SchoolTimetableService schoolTimetableService;

    private final StudentService studentService;

    private final SubjectService subjectService;

    private final AdminService adminService;

    @Autowired
    public GradeService(GradeMapper gradeMapper, LateService lateService, MessageService messageService, WorkService workService, NoteService noteService, NoticeService noticeService, SchoolTimetableService schoolTimetableService, StudentService studentService, SubjectService subjectService, AdminService adminService) {
        this.gradeMapper = gradeMapper;
        this.lateService = lateService;
        this.messageService = messageService;
        this.workService = workService;
        this.noteService = noteService;
        this.noticeService = noticeService;
        this.schoolTimetableService = schoolTimetableService;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.adminService = adminService;
    }

    /**
     * 选择性添加
     * 添加班级，属性为空的不添加
     *
     * @param grade
     * @return
     */
    public int insertSelective(Grade grade) {
        return gradeMapper.insertSelective(grade);
    }

    /**
     * 思路：先将查询所需要的条件传入vo类中，然后调用mapper中相应的方法。
     * 需要先手动把 多对多 查询的 xml 和 mapper.java 配置好。
     * 配置步骤：
     * 1、主表为grade，中间表为 subject，查询条件表为 teacher
     * 2、grade和teacher的xml都要编写statement，resultMap（sql语句相反）
     * <p>
     * 作用：通过 teacher 的id 到subject 表中查询老师所带的班级
     *
     * @param teacher
     * @return List<Grade>
     */
    public List<GradeVo> selectByTid(Teacher teacher) {
        // 获取 subject 表中老师所带的班级，多对多
        // 创建vo，将查询需要的条件传入
        // 调用mapper的方法获取班级
        GradeVo gradeVo = new GradeVo();
        List<GradeVo> gradeVos = gradeMapper.selectByTid(teacher.getTid());
        return gradeVos;
    }

    /**
     * 获取所有 班级
     *
     * @return
     */
    public List<Grade> selectAll() {
        return gradeMapper.selectByExample(null);
    }

    /**
     * 通过 gid 主键获取 grade
     *
     * @param gid
     * @return
     */
    public Grade selectByPrimaryKey(Integer gid) {
        return gradeMapper.selectByPrimaryKey(gid);
    }

    /**
     * 通过 id 更改 班级数据
     *
     * @param record
     * @return int
     */
    public int updateByPrimaryKey(Grade record) {
        return gradeMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据 主键id 删除班级
     *
     * @param gid
     * @return
     */
    public int deleteByPrimaryKey(Integer gid) {
        // 要级联删除的表：grade、late、message、work、note(笔记)、notice(公告)、school_timetable(课表)、student、
        // subject(课程)

        // 判断是否删除成功
        int result = 0;

        // 需要gid作为中间外键才能删除的表:note
        List<Subject> subjects = subjectService.selectByGid(gid);
        if (subjects.size() > 0) {
            for (Subject subject : subjects) {
                result += noteService.deleteBySjid(subject.getSjid());
            }
        }

        // 获取上下文对象
        WebApplicationContext web = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = web.getServletContext();

        // 需要删除文件和数据的表: schoolTimetab、late、work

        // 删除schoolTimetab中的文件 TODO 删除成功
        List<SchoolTimetable> schoolTimetables = schoolTimetableService.selectByStgid(gid);
        if (schoolTimetables.size() > 0) {
            List<String> stFiles = new LinkedList<>();
            for (SchoolTimetable schoolTimetable : schoolTimetables) {
                if (schoolTimetable.getStfile() != null || schoolTimetable.getStfile().isEmpty()) {
                    stFiles.add(schoolTimetable.getStfile());
                }
            }
            for (String stFile : stFiles) {
                UploadUtils.deleteFile(stFile, servletContext.getRealPath("/school_timetable"));
            }
        }

        // 删除work压缩包和work源文件 TODO 删除成功
        List<Work> works = workService.selectByGid(gid);
        if (works.size() > 0) {
            List<String> workFiles = new LinkedList<>();
            for (Work work : works) {
                if (work.getWfile() == null || work.getWfile().isEmpty()) {
                    continue;
                }
                workFiles.add(work.getWfile());
            }
            for (String workFile : workFiles) {
                UploadUtils.deleteFile(workFile, servletContext.getRealPath("/sourcefile"));
            }
        }

        // 删除late中的文件  TODO 删除成功
        List<Late> lates = lateService.selectByGid(gid);
        if (lates.size() > 0) {
            List<String> lateFiles = new LinkedList<>();
            List<String> uriFront = new ArrayList<>();
            for (Late late : lates) {
                if (late.getLfile() == null){
                    continue;
                }
                lateFiles.add(late.getLfile());
                String tempUri = late.getLweek() + "/" + late.getLwid();
                if (!uriFront.contains(tempUri)) {
                    uriFront.add(late.getLweek() + "/" + late.getLwid());
                }
            }
            // 作业所在文件夹 TODO 删除文件夹（wid）成功
            for (String uri : uriFront) {
                String lateUri = servletContext.getRealPath("/WEB-INF/workfiles/" + uri);
                System.out.println("late文件位置：" + servletContext.getRealPath("/WEB-INF/workfiles/" + uriFront));
                UploadUtils.recurisonDeleteFile(new File(lateUri));
            }
        }

        // 可以通过gid直接删除的表
        result += adminService.deleteByGid(gid);
        result += gradeMapper.deleteByPrimaryKey(gid);
        result += messageService.deleteByGid(gid);
        result += noticeService.deleteByGid(gid);
        result += studentService.deleteByGid(gid);
        result += subjectService.deleteByGid(gid);
        result += schoolTimetableService.deleteByGid(gid);
        result += workService.deleteByGid(gid);
        result += lateService.deleteByGid(gid);

        if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}