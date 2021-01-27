package test;

import com.worksystem.entity.SchoolTimetable;
import com.worksystem.entity.SchoolTimetableExample;
import com.worksystem.mapper.SchoolTimetableMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wsw16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class SchoolTimetableTest {

    @Autowired
    private SchoolTimetableMapper schoolTimetableMapper;

    @Test
    public void demo1(){
        SchoolTimetableExample example = new SchoolTimetableExample();

        // 设置判断条件
        example.or().andStgidEqualTo(1);

        List<SchoolTimetable> schoolTimetables = schoolTimetableMapper.selectByExample(example);

        for (SchoolTimetable schoolTimetable : schoolTimetables) {
            System.out.println(schoolTimetable.getStgid());
        }
    }

    @Test
    public void demo2(){
        SchoolTimetableExample example = new SchoolTimetableExample();
        // 测试example
        example.or().andStgidEqualTo(1).andStidEqualTo(1);

        // 包含修改后的数据的对象
        SchoolTimetable schoolTimetable = schoolTimetableMapper.selectByExample(example).get(0);
        schoolTimetable.setStfile("3333333333333333333333333333.png");

        System.out.println(schoolTimetableMapper.updateByExample(schoolTimetable, example));
        System.out.println(schoolTimetableMapper.selectByExample(example).get(0).getStfile());
    }

    @Test
    public void demo3(){
        SchoolTimetableExample example = new SchoolTimetableExample();
        // 测试example
        example.or().andStgidEqualTo(1).andStsemesterEqualTo(1);
        List<SchoolTimetable> schoolTimetables = schoolTimetableMapper.selectByExample(example);
        System.out.println(schoolTimetables.size());
        System.out.println(schoolTimetables.size() > 0);
    }

}
