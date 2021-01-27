package com.worksystem.mapper;

import com.worksystem.entity.SchoolTimetable;
import com.worksystem.entity.SchoolTimetableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolTimetableMapper {
    long countByExample(SchoolTimetableExample example);

    int deleteByExample(SchoolTimetableExample example);

    int deleteByPrimaryKey(Integer stid);

    int insert(SchoolTimetable record);

    int insertSelective(SchoolTimetable record);

    List<SchoolTimetable> selectByExample(SchoolTimetableExample example);

    SchoolTimetable selectByPrimaryKey(Integer stid);

    int updateByExampleSelective(@Param("record") SchoolTimetable record, @Param("example") SchoolTimetableExample example);

    int updateByExample(@Param("record") SchoolTimetable record, @Param("example") SchoolTimetableExample example);

    int updateByPrimaryKeySelective(SchoolTimetable record);

    int updateByPrimaryKey(SchoolTimetable record);
}