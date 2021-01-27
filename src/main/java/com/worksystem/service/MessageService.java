package com.worksystem.service;

import com.worksystem.entity.Message;
import com.worksystem.entity.MessageExample;
import com.worksystem.entity.PageSet;
import com.worksystem.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Service
public class MessageService {
    private final MessageMapper messageMapper;

    @Autowired
    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    /**
     * 添加一条数据
     * @param message
     * @return
     */
    public int insert(Message message) {
        return messageMapper.insert(message);
    }

    public PageSet selectMoreTableByWidToPageSet(Integer wid, Integer pno, Integer pageSize) {
        // 设置查询条件
        MessageExample example = new MessageExample();
        example.or().andMwidEqualTo(wid);
        // 设置排序
        example.setOrderByClause("mid desc");
        // 获取总记录数:total
        int total = (int) messageMapper.countByExample(example);
        // 获取总页数
        int pageCount = (int) Math.ceil((double)total/(double)pageSize);
        // 获取数据开始位置
        int start = (pno-1)*pageSize;
        // 封装数据到pageSet对象中
        PageSet pageSet = new PageSet();
        pageSet.setStart(start);
        pageSet.setTotal(total);
        pageSet.setPageCount(pageCount);
        pageSet.setPageSize(pageSize);
        // 获取数据
        List<Map<String, Object>> msgList = messageMapper.selectMoreTableLimit(pageSet, example);
        // 封装数据
        pageSet.setPageResult(msgList);
        // 返回pageSet对象
        return pageSet;
    }

    /**
     * 获取 message 表中与其他表进行内连接得出的 所有数据
     * @return
     */
    public List<Map<String, Object>> selectAllMoreTable() {
        MessageExample example = new MessageExample();
        // 设置排序
        example.setOrderByClause("mid desc");
        return messageMapper.selectMoreTableExample(example);
    }


    /**
     * 根据 班级id 查询数据
     * @return
     */
    public List<Map<String, Object>> selectMoreTableByGid(Integer gid) {
        MessageExample example = new MessageExample();
        // 设置排序
        example.setOrderByClause("mid desc");
        // 设置条件
        example.or().andMgidEqualTo(gid);
        return messageMapper.selectMoreTableExample(example);
    }

    /**
     * 根据 班级id 查询数据
     * @return
     */
    public List<Map<String, Object>> selectMoreTableByWid(Integer wid) {
        MessageExample example = new MessageExample();
        // 设置排序
        example.setOrderByClause("mid desc");
        // 设置条件
        example.or().andMwidEqualTo(wid);
        return messageMapper.selectMoreTableExample(example);
    }

    /**
     * 根据 作业id 查询数据
     * 与selectMoreTableByGid()方法相比，少 内连接 一张表
     * @param wid
     * @return
     */
    public List<Map<String, Object>> selectFewTableExampleByWid(Integer wid) {
        MessageExample example = new MessageExample();
        // 设置排序
        example.setOrderByClause("mid desc");
        // 设置条件
        example.or().andMgidEqualTo(wid);
        return messageMapper.selectMoreTableExample(example);
    }

    /**
     * 根据 主键 删除数据
     * @param mid
     * @return
     */
    public int deleteByPrimaryKey(Integer mid) {
        return messageMapper.deleteByPrimaryKey(mid);
    }

    /**
     * 根据 班级id 删除数据
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        MessageExample example = new MessageExample();
        // 设置条件
        example.or().andMgidEqualTo(gid);
        return messageMapper.deleteByExample(example);
    }
}
