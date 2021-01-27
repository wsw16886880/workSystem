package test;

import com.worksystem.entity.Student;
import com.worksystem.entity.StudentExample;
import com.worksystem.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class StudentTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void demo1(){
        StudentExample example = new StudentExample();
        // 设置条件
        example.or().andSgidEqualTo("1");
        List<Student> students = studentMapper.selectByExample(example);
        for (Student student : students) {
            System.out.println(student.getSname());
        }
    }

    @Test
    public void demo2(){
        StudentExample example = new StudentExample();
        // 不设置条件
        List<Map<String, Object>> maps = studentMapper.selectAndGname(example);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        // 设置条件
        example.or().andSgidEqualTo("1");
        List<Map<String, Object>> maps2 = studentMapper.selectAndGname(example);
        for (Map<String, Object> map : maps2) {
            System.out.println(map);
        }

    }

    @Test
    public void demo3(){
        Student student = new Student();
        student.setSnumber("201872130142");
        student.setSpwd("1234356");

        StudentExample example = new StudentExample();
        // 1.设置条件，先查询是否有账号
        example.or().andSnumberEqualTo(student.getSnumber());
        // 连接数据库，查询数据 TODO
        System.out.println(studentMapper.selectByExample(example).size());
        example.or().andSpwdEqualTo(student.getSpwd());
        example.clear();
        example.or().andSnumberEqualTo(student.getSnumber()).andSpwdEqualTo(student.getSpwd());
        System.out.println(studentMapper.selectByExample(example).size());
    }
}
