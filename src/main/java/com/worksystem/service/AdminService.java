package com.worksystem.service;

import com.worksystem.entity.Admin;
import com.worksystem.entity.AdminExample;
import com.worksystem.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 通过 主键 查询单条数据
     * @param aid
     * @return
     */
    public Admin selectByPrimaryKey(Integer aid) {
        return adminMapper.selectByPrimaryKey(aid);
    }

    /**
     * 获取所有学委和对应的班级名称
     *
     * @return
     */
    public List<Map<String, Object>> selectAllAndGname() {
        return adminMapper.selectAllAndGname();
    }

    /**
     * 根据账号和密码匹配数据
     *
     * @param admin
     * @return
     */
    public Admin selectByAccount(Admin admin) {
        return adminMapper.selectByAccount(admin);
    }

    /**
     * 选择性添加
     * 添加 单条 数据，属性不为空，则添加
     *
     * @param admin
     * @return
     */
    public int insertSelective(Admin admin) {
        return adminMapper.insertSelective(admin);
    }

    /**
     * 根据 主键 删除数据
     *
     * @param aid
     * @return
     */
    public int deleteByPrimaryKey(Integer aid) {
        return adminMapper.deleteByPrimaryKey(aid);
    }

    /**
     * 根据 班级id 删除学委
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        AdminExample example = new AdminExample();
        // 设置条件
        example.or().andAgidEqualTo(gid);
        return adminMapper.deleteByExample(example);
    }

    /**
     * 根据id更改学委信息
     * @param admin
     * @param aid
     * @return
     */
    public int updateByPrimaryKey(Admin admin, Integer aid) {
        admin.setAid(aid);
        return adminMapper.updateByPrimaryKey(admin);
    }
}
