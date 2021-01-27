package com.worksystem.service;

import com.worksystem.entity.Work;
import com.worksystem.entity.WorkExample;
import com.worksystem.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Service
public class WorkService {

    private final WorkMapper workMapper;

    @Autowired
    public WorkService(WorkMapper workMapper) {
        this.workMapper = workMapper;
    }

    /**
     * 选择性添加字段
     * 添加 单条 数据，属性为空则不添加该字段
     * @param work
     * @return
     */
    public int insertSelective(Work work) {
        return workMapper.insertSelective(work);
    }

    /**
     * 根据 班级id 查询多条数据
     * @param gid
     * @return
     */
    public List<Work> selectByGid(Integer gid) {
        WorkExample example = new WorkExample();
        // 设置条件
        example.or().andWgidEqualTo(gid);
        return workMapper.selectByExample(example);
    }

    /**
     * 根据 作业id 查询work、grade、subject表的单条数据
     * @param wid
     * @return
     */
    public Map<String,Object> selectOneMoreTableExampleByWid(Integer wid) {
        WorkExample example = new WorkExample();
        // 设置条件
        example.or().andWidEqualTo(wid);
        // 查询数据
        List<Map<String, Object>> works = workMapper.selectMoreTableExampleByExample(example);
        // 返回第一条数据
        return works.get(0);
    }

    /**
     * 根据 主键 查询单条数据
     * @param wid
     * @return
     */
    public Work selectByPrimaryKey(Integer wid) {
        return workMapper.selectByPrimaryKey(wid);
    }

    /**
     * 获取 满足wgid=gid 条件的 work表和grade表的所有数据
     * @return
     */
    public List<Map<String, Object>> selectAllFewTable() {
        WorkExample example = new WorkExample();
        // 设置排序
        example.setOrderByClause("wid desc");
        // 查询并返回数据
        return workMapper.selectFewTableExample(example);
    }

    /**
     * 根据 班级id 查询相关的 满足 wgid=gid 条件的 work表和grade表的所有数据
     * @param gid
     * @return
     */
    public List<Map<String, Object>> selectFewTableByGid(Integer gid) {
        WorkExample example = new WorkExample();
        // 设置排序
        example.setOrderByClause("wid desc");
        // 设置条件
        example.or().andWgidEqualTo(gid);
        // 查询并返回数据
        return workMapper.selectFewTableExample(example);
    }

    /**
     * 根据 老师id 查询相关的 满足 wgid=gid 条件的 work表和grade表的所有数据
     * @param tid
     * @return
     */
    public List<Map<String, Object>> selectFewTableByTid(Integer tid) {
        WorkExample example = new WorkExample();
        // 设置排序
        example.setOrderByClause("wid desc");
        // 设置条件
        example.or().andWgidEqualTo(tid);
        // 查询并返回数据
        return workMapper.selectFewTableExample(example);
    }

    /**
     * 选择性更改
     * 根据 主键 更改单条数据，属性为空的对应字段不更改
     * @param work
     * @return
     */
    public int updateByPrimaryKeySelective(Work work) {
        return workMapper.updateByPrimaryKeySelective(work);
    }

    /**
     * 更改交作业人数
     * @param wid
     * @return
     */
    public int updateWtotal(Integer wid) {
        return workMapper.updateWtotal(wid);
    }

    /**
     * 根据 主键 删除单条数据
     * @param wid
     * @return
     */
    public int deleteByPrimaryKey(Integer wid) {
        return workMapper.deleteByPrimaryKey(wid);
    }

    /**
     * 根据 班级id 删除数据
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        WorkExample example = new WorkExample();
        // 设置条件
        example.or().andWgidEqualTo(gid);
        return workMapper.deleteByExample(example);
    }

}
