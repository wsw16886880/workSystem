package com.worksystem.service;

import com.worksystem.entity.Notice;
import com.worksystem.entity.NoticeExample;
import com.worksystem.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Service
public class NoticeService {
    private final NoticeMapper noticeMapper;

    @Autowired
    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    /**
     * 选择性添加
     * 添加 单条数据，属性不为空，则添加，为空就不添加
     *
     * @param notice
     * @return
     */
    public int insertSelective(Notice notice) {
        return noticeMapper.insertSelective(notice);
    }

    /**
     * 根据 班级id 查询是否有紧急通知
     * 如果有，返回最新的紧急通知的 id
     * @param gid
     * @return
     */
    public int selectNemergencyByGid(Integer gid) {
        NoticeExample example = new NoticeExample();
        // 设置排序，倒序
        example.setOrderByClause("nid desc");
        // 设置条件
        example.or().andNgidEqualTo(gid).andNemergencyEqualTo(1);
        // 查询数据库
        List<Notice> notices = noticeMapper.selectByExample(example);
        // 判断是否有紧急通知
        if (notices.size() > 0) {
            return notices.get(0).getNid();
        }
        return 0;
    }


    /**
     * 获取所有 公告 和 所属的班级 数据
     *
     * @return
     */
    public List<Map<String, Object>> selectNoticeAndGrade() {
        NoticeExample example = new NoticeExample();
        // 设置倒序
        example.setOrderByClause("nid desc");
        return noticeMapper.selectNoticeAndGrade(example);
    }

    /**
     * 通过 gid 获取 公告 和 所属的班级 数据
     *
     * @return
     */
    public List<Map<String, Object>> selectNoticeAndGradeByNgid(Integer gid) {
        NoticeExample example = new NoticeExample();
        // 设置倒序
        example.setOrderByClause("nid desc");
        // 设置条件
        example.or().andNgidEqualTo(gid);
        return noticeMapper.selectNoticeAndGrade(example);
    }

    /**
     * 通过 gid和ntype 获取 公告 和 所属的班级 数据
     *
     * @return
     */
    public List<Map<String, Object>> selectNoticeAndGradeByNgidAndNtype(Notice notice) {
        NoticeExample example = new NoticeExample();
        // 设置倒序
        example.setOrderByClause("nid desc");
        // 设置条件
        example.or().andNgidEqualTo(notice.getNgid()).andNtypeEqualTo(notice.getNtype());
        return noticeMapper.selectNoticeAndGrade(example);
    }

    /**
     * 通过 主键 查找数据
     *
     * @param nid
     * @return
     */
    public Notice selectByPrimaryKey(Integer nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }

    /**
     * 选择性更改数据
     * 根据 id 更改数据，属性为空则不会更改
     *
     * @param notice
     * @return
     */
    public int updateByExampleSelective(Notice notice) {
        NoticeExample example = new NoticeExample();
        // 设置条件
        example.or().andNidEqualTo(notice.getNid());
        return noticeMapper.updateByExampleSelective(notice, example);
    }

    /**
     * 通过 主键 删除数据
     *
     * @param nid
     * @return
     */
    public int deleteByPrimaryKey(Integer nid) {
        return noticeMapper.deleteByPrimaryKey(nid);
    }

    /**
     * 根据 班级id 删除数据
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        NoticeExample example = new NoticeExample();
        // 设置条件
        example.or().andNgidEqualTo(gid);
        return noticeMapper.deleteByExample(example);
    }
}
