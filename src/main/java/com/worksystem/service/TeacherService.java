package com.worksystem.service;

import com.worksystem.entity.Teacher;
import com.worksystem.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherMapper teacherMapper;

    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public Teacher selectByTaccount(Teacher teacher) {
        return teacherMapper.selectByTaccount(teacher);
    }


    /**
     * 添加 单条 数据
     * @param teacher
     * @return
     */
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    /**
     * 根据 主键 查询数据
     * @param tid
     * @return
     */
    public Teacher selectByPrimaryKey(Integer tid) {
        return teacherMapper.selectByPrimaryKey(tid);
    }

    /**
     * 查询所有老师
     * @return
     */
    public List<Teacher> selectAll() {
        return teacherMapper.selectByExample(null);
    }

    /**
     * 根据 主键 更改数据
     * @param teacher
     * @return
     */
    public int updateByPrimaryKey(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    /**
     * 根据 主键 删除单条数据
     * @param tid
     * @return
     */
    public int deleteByPrimaryKey(Integer tid) {
        return teacherMapper.deleteByPrimaryKey(tid);
    }
}
