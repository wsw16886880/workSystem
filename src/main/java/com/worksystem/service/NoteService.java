package com.worksystem.service;

import com.worksystem.entity.Note;
import com.worksystem.entity.NoteExample;
import com.worksystem.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Service
public class NoteService {

    private final NoteMapper noteMapper;

    private final SubjectService subjectService;

    private final WorkService workService;

    @Autowired
    public NoteService(NoteMapper noteMapper, SubjectService subjectService, WorkService workService) {
        this.noteMapper = noteMapper;
        this.subjectService = subjectService;
        this.workService = workService;
    }


    /**
     * 查询 与多个表 连接的所有数据
     * @return
     */
    public List<Map<String, Object>> selectMoreTable() {
        NoteExample example = new NoteExample();
        // 设置排序
        example.setOrderByClause("nid desc");
        // 查询并返回数据
        return noteMapper.selectMoreTable(example);
    }

    /**
     * 通过 nid 来获取笔记、作业、课程表的关联信息
     * @param nid
     * @return
     */
    public Map<String, Object> selectMoreTableByNid(Integer nid) {
        NoteExample example = new NoteExample();
        // 设置条件
        example.or().andNidEqualTo(nid);
        // 查询并返回数据
        List<Map<String, Object>> maps = noteMapper.selectMoreTable(example);
        return maps.get(0);
    }

    /**
     *
     * @param studyYear 获取该学年的笔记
     * @param sgid 班级id
     * @return
     */
    public List<Map<String, Object>> getNoteListByGidSemester(Integer studyYear, Integer sgid){
        Map<String, Object> map = new HashMap<>();
        // 判断要获取哪一个学年的笔记
        if(studyYear == 1) {
            map.put("wgid", sgid);
            map.put("semester_one", 1);
            map.put("semester_two", 2);
        } else if (studyYear == 2) {
            map.put("wgid", sgid);
            map.put("semester_one", 3);
            map.put("semester_two", 4);
        } else {
            map.put("wgid", sgid);
            map.put("semester_one", 5);
            map.put("semester_two", 6);
        }
        // 获取数据
        return noteMapper.selectNoteByGidSemester(map);
    }

    /**
     * 根据 nsjid（课程） 查询 周数
     * @param nsjid
     * @return
     */
    public List<Map<String, Object>> getNweekByNsjid(Integer nsjid) {
        NoteExample example = new NoteExample();
        // 设置条件
        example.or().andNsjidEqualTo(9);
        // 查询
        List<Map<String, Object>> maps = noteMapper.selectMoreTable(example);
        List<Map<String, Object>> nweeks = new ArrayList<>();
        for(int i = 0; i < maps.size(); i++){
            Map<String, Object> map = new HashMap<>();
            map.put("nweek", maps.get(i).get("nweek"));
            nweeks.add(map);
        }
        return nweeks;
    }

    /**
     * 根据 课程id 查找多表数据
     * @param nsjig
     * @return
     */
    public List<Map<String, Object>> selectMoreTableByNsjid(Integer nsjig) {
        NoteExample example = new NoteExample();
        // 设置排序
        example.setOrderByClause("nid desc");
        // 设置条件
        example.or().andNsjidEqualTo(nsjig);
        // 查询数据库
        return noteMapper.selectMoreTable(example);
    }

    /**
     * 根据 课程id和周数 查询多表数据
     * @param nsjig
     * @param nweek
     * @return
     */
    public List<Map<String, Object>> selectMoreTableByNsjidAndNweek(Integer nsjig, Integer nweek) {
        NoteExample example = new NoteExample();
        // 设置排序
        example.setOrderByClause("nid desc");
        // 设置条件
        example.or().andNsjidEqualTo(nsjig).andNweekEqualTo(nweek);
        // 查询数据库
        return noteMapper.selectMoreTable(example);
    }

    /**
     * 根据 班级id 查询属于该班级的数据
     * @param gid
     * @return
     */
    public List<Map<String, Object>> selectMoreTableBySjgid(Integer gid) {
        return noteMapper.selectMoreTableBySjgid(gid);
    }

    /**
     * 通过 科目id 查询 nweek
     * @param sjid
     * @return
     */
    public List<Note> selectNweekBySjid(Integer sjid) {
        NoteExample example = new NoteExample();
        // 设置条件
        example.or().andNsjidEqualTo(sjid);
        // 获取 nweek
        List<Note> nweeks = new ArrayList<>();
        List<Note> notes = noteMapper.selectByExample(example);
        for (Note note : notes) {
            Note temp = new Note();
            temp.setNweek(note.getNweek());
            nweeks.add(temp);
        }
        return nweeks;
    }

    /**
     * 通过 科目、作业 的主键 获取对应的名称
     * @param note
     * @return relate
     */
    public Map<String, Object> relate(Note note) {
        String sjname = subjectService.selectByPrimaryKey(note.getNsjid()).getSjname();
        String wname = null;
        try {
            wname = workService.selectByPrimaryKey(note.getNwid()).getWname();
        } catch (Exception e) {
            System.out.println("该课程没有对应作业！");
            wname = "无";
        }
        Map<String,Object> relate = new HashMap<>();
        relate.put("sjname", sjname);
        relate.put("wname", wname);
        return relate;
    }

    /**
     * 通过 主键 查询单条数据
     * @param nid
     * @return
     */
    public Note selectByPrimaryKey(Integer nid) {
        return noteMapper.selectByPrimaryKey(nid);
    }

    /**
     * 选择性添加
     * 添加单行数据，不添加属性为空的字段
     * @param note
     * @return
     */
    public int insertSelective(Note note) {
        return noteMapper.insertSelective(note);
    }

    /**
     * 根据主键修改笔记
     * @param note
     * @return
     */
    public int updateByPrimaryKey(Note note) {
        return noteMapper.updateByPrimaryKey(note);
    }

    /**
     * 根据 主键 删除
     * @param nid
     * @return
     */
    public int deleteByPrimaryKey(Integer nid) {
        return noteMapper.deleteByPrimaryKey(nid);
    }

    /**
     * 根据 课程id 删除数据
     * @param sjid
     * @return
     */
    public int deleteBySjid(Integer sjid) {
        NoteExample example = new NoteExample();
        // 设置条件
        example.or().andNsjidEqualTo(sjid);
        return noteMapper.deleteByExample(example);
    }
}
