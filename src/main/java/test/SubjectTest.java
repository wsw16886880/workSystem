package test;

import com.worksystem.entity.Subject;
import com.worksystem.entity.SubjectExample;
import com.worksystem.mapper.SubjectMapper;
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
public class SubjectTest {

    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    public void test1(){
        int studyYear = 1;
        SubjectExample example = new SubjectExample();
        // 判断要获取哪一个学年的课程
        if(studyYear == 1) {
            example.or().andSjgidEqualTo(7).andSjsemesterBetween(1,2);
        } else if (studyYear == 2) {
            example.or().andSjgidEqualTo(7).andSjsemesterBetween(3,4);
        } else {
            example.or().andSjgidEqualTo(7).andSjsemesterBetween(5,6);
        }
        // 获取数据
        List<Subject> subjects = subjectMapper.selectByExample(example);

        System.out.println(subjects);
    }
}
