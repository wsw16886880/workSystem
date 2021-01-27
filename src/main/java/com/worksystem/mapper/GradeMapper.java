package com.worksystem.mapper;

import com.worksystem.entity.Grade;
import com.worksystem.entity.GradeExample;
import com.worksystem.entity.GradeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {
    long countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    List<GradeVo> selectByTid(Integer tid);

    Grade selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}