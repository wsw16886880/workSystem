package test;

import com.worksystem.entity.NoteExample;
import com.worksystem.mapper.NoteMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class NoteTest {

    @Autowired
    private NoteMapper noteMapper;

    @Test
    public void demo1(){
        NoteExample example = new NoteExample();
        // 设置排序
        example.setOrderByClause("nid desc");
        List<Map<String, Object>> maps = noteMapper.selectMoreTable(example);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
            System.out.println(map.get("sjgid"));
        }
    }

    @Test
    public void demo2(){
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

        System.out.println(nweeks);
    }

    @Test
    public void demo3(){
        Integer studyYear = 1;
        int sgid = 7;
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
        List<Map<String, Object>> maps = noteMapper.selectNoteByGidSemester(map);
    }
}
