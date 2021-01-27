package com.worksystem.mapper;

import com.worksystem.entity.Late;
import com.worksystem.entity.LateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LateMapper {
    long countByExample(LateExample example);

    int deleteByExample(LateExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(Late record);

    int insertSelective(Late record);

    List<Late> selectByExampleWithBLOBs(LateExample example);

    List<Late> selectByExample(LateExample example);

    List<Map<String, Object>> selectMoreTableBySemester(Map map);

    Late selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") Late record, @Param("example") LateExample example);

    int updateByExampleWithBLOBs(@Param("record") Late record, @Param("example") LateExample example);

    int updateByExample(@Param("record") Late record, @Param("example") LateExample example);

    int updateByPrimaryKeySelective(Late record);

    int updateByPrimaryKeyWithBLOBs(Late record);

    int updateByPrimaryKey(Late record);
}