package com.worksystem.mapper;

import com.worksystem.entity.Note;
import com.worksystem.entity.NoteExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NoteMapper {
    long countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(Integer nid);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExample(NoteExample example);

    List<Map<String, Object>> selectMoreTable(NoteExample example);

    List<Map<String, Object>> selectMoreTableBySjgid(Integer gid);

    List<Map<String, Object>> selectNoteByGidSemester(Map map);

    Note selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}