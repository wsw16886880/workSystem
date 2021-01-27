package com.worksystem.service;

import com.worksystem.entity.SchoolTimetable;
import com.worksystem.entity.SchoolTimetableExample;
import com.worksystem.mapper.SchoolTimetableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolTimetableService {

    @Autowired
    private SchoolTimetableMapper schoolTimetableMapper;

    /**
     * 插入一条数据
     * @param record
     * @return
     */
    public int insert(SchoolTimetable record) {
        return schoolTimetableMapper.insert(record);
    }

    public int check(Integer stgid, Integer stsemester) {
        SchoolTimetableExample example = new SchoolTimetableExample();
        // 设置条件
        example.or().andStgidEqualTo(stgid).andStsemesterEqualTo(stsemester);
        // 查询数据，返回list.size()
        return schoolTimetableMapper.selectByExample(example).size();
    }

    /**
     * 根据 主键 查询单条数据
     * @param gid
     * @return
     */
    public SchoolTimetable selectByPrimaryKey(Integer gid) {
        return schoolTimetableMapper.selectByPrimaryKey(gid);
    }

    /**
     * 根据 班级id 和 学期 查询数据
     * @param record
     * @return
     */
    public List<SchoolTimetable> selectByExample(SchoolTimetable record) {
        SchoolTimetableExample example = new SchoolTimetableExample();
        example.or().andStgidEqualTo(record.getStgid()).andStsemesterEqualTo(record.getStsemester());
        return schoolTimetableMapper.selectByExample(example);
    }

    /**
     * 根据 班级id 和 学期 查询 图片 数据
     * @param gid
     * @param stsemester
     * @return
     */
    public String selectStfileByGidAndStse(Integer gid, Integer stsemester) {
        SchoolTimetableExample example = new SchoolTimetableExample();
        example.or().andStgidEqualTo(gid).andStsemesterEqualTo(stsemester);
        // 判断图片是否存在
        List<SchoolTimetable> schoolTimetables = schoolTimetableMapper.selectByExample(example);
        if(schoolTimetables.size() > 0) {
            return schoolTimetables.get(0).getStfile();
        }
        // 没有则返回空字符串
        return "";
    }

    /**
     * 根据 班级id 查询多条数据
     * @param gid
     * @return
     */
    public List<SchoolTimetable> selectByStgid(Integer gid){
        // 获取example
        SchoolTimetableExample example = new SchoolTimetableExample();
        // 设置排序
        example.setOrderByClause("stsemester");
        // 设置条件
        example.or().andStgidEqualTo(gid);
        return schoolTimetableMapper.selectByExample(example);
    }

    public int updateByPrimaryKey(SchoolTimetable schoolTimetable) {
        return schoolTimetableMapper.updateByPrimaryKey(schoolTimetable);
    }

    /**
     * 通过 example类 来更改数据
     * @param record
     * @return
     */
    public int updateByExample(SchoolTimetable record) {
        SchoolTimetableExample example = new SchoolTimetableExample();
        // 设置更改条件
        example.or().andStgidEqualTo(record.getStgid()).andStsemesterEqualTo(record.getStsemester());
        // 调用数据库更改方法，返回影响多少行
        return schoolTimetableMapper.updateByExample(record, example);
    }

    /**
     * 通过 example类 删除记录
     * @param record
     * @return
     */
    public int deleteByExample(SchoolTimetable record) {
        SchoolTimetableExample example = new SchoolTimetableExample();
        // 设置删除条件
        example.or().andStgidEqualTo(record.getStgid()).andStsemesterEqualTo(record.getStsemester());
        // 调用数据库的删除方法
        return schoolTimetableMapper.deleteByExample(example);
    }

    /**
     * 根据 班级id 删除数据
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        SchoolTimetableExample example = new SchoolTimetableExample();
        // 设置条件
        example.or().andStgidEqualTo(gid);
        return schoolTimetableMapper.deleteByExample(example);
    }

}
