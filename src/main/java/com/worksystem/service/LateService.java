package com.worksystem.service;

import com.worksystem.entity.Late;
import com.worksystem.entity.LateExample;
import com.worksystem.entity.Student;
import com.worksystem.mapper.LateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Service
public class LateService {

    private final LateMapper lateMapper;

    private final StudentService studentService;

    @Autowired
    public LateService(LateMapper lateMapper, StudentService studentService) {
        this.lateMapper = lateMapper;
        this.studentService = studentService;
    }

    /**
     * 批量添加学生
     * @param late
     * @param gid
     * @return
     */
    public int insertBatch(Late late, Integer gid) {
        // 获取要添加作业的班级的所有学生学生
        List<Student> students = studentService.selectByGid(gid);
        // 循环添加，计数
        int result = 0;
        for (Student student : students) {
            late.setLsid(student.getSid());
            late.setLsname(student.getSname());
            late.setLsnumber(student.getSnumber());
            late.setLgid(Integer.valueOf(student.getSgid()));
            result += lateMapper.insert(late);
        }
        return result;
    }

    /**
     * 根据 班级id和周数 查询作业
     * @param sid
     * @param week
     * @return
     */
    public List<Late> selectBySidAndWeed(Integer sid, Integer week) {
        LateExample example = new LateExample();
        // 判断要查询的周数
        if (week == 0) {
            // 设置查询条件
            example.or().andLsidEqualTo(sid);
        } else {
            example.or().andLsidEqualTo(sid).andLweekEqualTo(week);
        }
        // 设置排列
        example.setOrderByClause("lsid desc");
        // 查询数据库
        return lateMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 根据 学生id 和 学年 获取作业列表
     * @param sid
     * @param studyYear
     * @return
     */
    public List<Map<String, Object>> selectMoreTableBySemester(Integer sid, Integer studyYear){
        Map<String, Object> map = new HashMap<>();
        // 判断要获取哪一个学年的笔记
        if(studyYear == 1) {
            map.put("sid", sid);
            map.put("semester_one", 1);
            map.put("semester_two", 2);
        } else if (studyYear == 2) {
            map.put("sid", sid);
            map.put("semester_one", 3);
            map.put("semester_two", 4);
        } else {
            map.put("sid", sid);
            map.put("semester_one", 5);
            map.put("semester_two", 6);
        }
        // 获取数据
        return lateMapper.selectMoreTableBySemester(map);
    }

    /**
     * 通过 tid 查询数据
     * @param tid
     * @return
     */
    public List<Late> selectByTid(Integer tid) {
        LateExample example = new LateExample();
        // 添加条件
        example.or().andLtidEqualTo(tid);
        // 查询数据并返回
        return  lateMapper.selectByExample(example);
    }

    /**
     * 根据 班级id 查询数据
     * @param gid
     * @return
     */
    public List<Late> selectByGid(Integer gid) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLgidEqualTo(gid);
        // 查询数据并返回
        return lateMapper.selectByExample(example);
    }

    /**
     * 根据 班级id 和 workId 查询数据
     * @param gid
     * @param wid
     * @return
     */
    public List<Late> selectByGidAndWid(Integer gid, Integer wid){
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLgidEqualTo(gid).andLwidEqualTo(wid);
        // 查询数据并返回
        return lateMapper.selectByExample(example);
    }

    /**
     * 通过 wid 查询相应数据
     * @param wid
     * @return
     */
    public List<Late> selectByWid(Integer wid) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLwidEqualTo(wid);
        // 连接数据库查询数据
        return lateMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 获取上交的作业的文件名
     * @param late
     * @return
     */
    public String getFileName(Late late) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLsidEqualTo(late.getLsid()).andLweekEqualTo(late.getLweek()).andLwidEqualTo(late.getLwid());
        // 连接数据库查询数据
        List<Late> lates = lateMapper.selectByExample(example);
        Late result = lates.get(0);
        return result.getLfile();
    }

    /**
     * 获取所有 late 数据
     * @return
     */
    public List<Late> selectAll() {
        return lateMapper.selectByExample(null);
    }

    /**
     * 根据 作业id 查询数据总条数
     * @param wid
     * @return
     */
    public long countByWid(Integer wid) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLwidEqualTo(wid);
        // 连接数据库查询数据
        return lateMapper.countByExample(example);
    }

    /**
     * 选择性更改
     * 根据 作业id 更改单条数据，属性为空则对应字段不更改
     * @param late
     * @return
     */
    public int updateByWidSelective(Late late) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLwidEqualTo(late.getLwid());
        return lateMapper.updateByExampleSelective(late, example);
    }

    /**
     * 选择性更改
     * 根据 学生id、周数、作业id 更改作业提交信息
     * 除了issubmit属性和上面3个属性不为空，其他属性均为空
     * @param late
     * @return
     */
    public int updateByLsidAndLweekAndLwid(Late late) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLsidEqualTo(late.getLsid()).andLweekEqualTo(late.getLweek()).andLwidEqualTo(late.getLwid());
        // 更改数据
        return lateMapper.updateByExampleSelective(late, example);
    }

    /**
     * 根据 wid 删除单条或多条数据
     * @param wid
     * @return int
     */
    public int deleteByWid(Integer wid) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLwidEqualTo(wid);
        // 连接数据库，删除数据
        return lateMapper.deleteByExample(example);
    }

    /**
     * 根据 班级id 删除数据
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        LateExample example = new LateExample();
        // 设置条件
        example.or().andLgidEqualTo(gid);
        return lateMapper.deleteByExample(example);
    }
}
