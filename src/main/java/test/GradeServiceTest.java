package test;

import com.worksystem.entity.GradeExample;
import com.worksystem.entity.GradeVo;
import com.worksystem.entity.Teacher;
import com.worksystem.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wsw16
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml", "classpath*:/springmvc.xml", "classpath*:/mybatis-config.xml"})
public class GradeServiceTest {

    @Autowired
    private GradeService gradeService;

    @Test
    public void demo1(){
//        List<Grade> grades = gradeService.selectByExample(null);
//        System.out.println(((Grade)grades.toArray()[0]).getGname());
    }

    @Test
    public void demo2(){
        Teacher teacher = new Teacher();
        teacher.setTid(1);
        List<GradeVo> gradeVos = gradeService.selectByTid(teacher);
        System.out.println(gradeVos.get(0).getGname());
        System.out.println(gradeVos.get(1).getGname());
    }

    @Test
    public void demo3(){
        GradeExample example = new GradeExample();
        example.or().andGidEqualTo(1);

//        List<Grade> grades = gradeService.selectByExample(example);

//        for (Grade grade : grades) {
//            System.out.println(grade.getGname());
//        }
    }

}
