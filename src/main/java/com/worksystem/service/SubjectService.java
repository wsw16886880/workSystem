package com.worksystem.service;

import com.worksystem.entity.Subject;
import com.worksystem.entity.SubjectExample;
import com.worksystem.entity.Teacher;
import com.worksystem.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Service
public class SubjectService {

    private final SubjectMapper subjectMapper;

    private final TeacherService teacherService;

    public SubjectService(SubjectMapper subjectMapper, TeacherService teacherService) {
        this.subjectMapper = subjectMapper;
        this.teacherService = teacherService;
    }

    /**
     * 添加 单条 数据
     * @param subject
     * @return
     */
    public int insert(Subject subject) {
        return subjectMapper.insert(subject);
    }

    /**
     * 通过 主键 查询单条记录
     * @param sjid
     * @return
     */
    public Subject selectByPrimaryKey(Integer sjid) {
        return subjectMapper.selectByPrimaryKey(sjid);
    }

    /**
     * 根据 学期 和 班级id 获取课程
     * @param studyYear
     * @param sjgid
     * @return
     */
    public List<Subject> getSubjectBySjgidSjsemester(Integer studyYear, Integer sjgid){
        SubjectExample example = new SubjectExample();
        // 判断要获取哪一个学年的课程
        if(studyYear == 1) {
            example.or().andSjgidEqualTo(sjgid).andSjsemesterBetween(1,2);
        } else if (studyYear == 2) {
            example.or().andSjgidEqualTo(sjgid).andSjsemesterBetween(3,4);
        } else {
            example.or().andSjgidEqualTo(sjgid).andSjsemesterBetween(5,6);
        }
        // 获取数据
        return subjectMapper.selectByExample(example);
    }

    /**
     * 查询所有课程和所对应的班级
     * @return
     */
    public List<Map<String, Object>> selectSubjectAndGrade() {
        return subjectMapper.selectSubjectAndGrade();
    }

    /**
     * 查询所有课程
     * @return
     */
    public List<Subject> selectAll() {
        return subjectMapper.selectByExample(null);
    }

    /**
     * 通过 班级id 来查询相应的 班级subject
     * @param gid
     * @return
     */
    public List<Subject> selectByGid(Integer gid) {
        SubjectExample example = new SubjectExample();
        // 设置条件
        example.or().andSjgidEqualTo(gid);
        // 查询数据
        return subjectMapper.selectByExample(example);
    }

    /**
     * 通过 老师id 来查询相应的 班级subject
     * @param tid
     * @return
     */
    public List<Subject> selectByTid(Integer tid) {
        SubjectExample example = new SubjectExample();
        // 设置条件
        example.or().andSjgidEqualTo(tid);
        // 查询数据
        return subjectMapper.selectByExample(example);
    }

    /**
     * 通过 主键 删除课程
     * 只会删除课程，尚未做删除相关数据
     * @param sjid
     * @return
     */
    public int deleteByPrimaryKey(Integer sjid) {
        return subjectMapper.deleteByPrimaryKey(sjid);
    }

    /**
     * 根据 班级id 删除数据
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        SubjectExample example = new SubjectExample();
        // 设置条件
        example.or().andSjgidEqualTo(gid);
        return subjectMapper.deleteByExample(example);
    }

    /**
     * 根据id修改课程数据
     * @param subject
     * @param sjid
     * @return
     */
    public int updateByPrimaryKey(Subject subject, Integer sjid){
        subject.setSjid(sjid);
        Teacher teacher = teacherService.selectByPrimaryKey(subject.getSjtid());
        subject.setSjtname(teacher.getTname());
        return  subjectMapper.updateByPrimaryKey(subject);
    }
}
