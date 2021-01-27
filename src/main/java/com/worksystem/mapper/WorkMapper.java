package com.worksystem.mapper;

import com.worksystem.entity.Work;
import com.worksystem.entity.WorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Integer wid);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExampleWithBLOBs(WorkExample example);

    List<Work> selectByExample(WorkExample example);

    List<Map<String, Object>> selectFewTableExample(WorkExample example);

    List<Map<String,Object>> selectMoreTableExampleByExample(WorkExample example);

    Work selectByPrimaryKey(Integer wid);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExampleWithBLOBs(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKeyWithBLOBs(Work record);

    int updateByPrimaryKey(Work record);

    int updateWtotal(Integer wid);
}