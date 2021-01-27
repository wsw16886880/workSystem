package test;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Grade;
import com.worksystem.entity.GradeExample;
import com.worksystem.mapper.AdminMapper;
import com.worksystem.mapper.GradeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wsw16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"classpath*:/applicationContext.xml", "classpath*:/springmvc.xml", "classpath*:/mybatis-config.xml"})
public class MybatisGeneratorTest {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private GradeMapper gradeMapper;

    @Test
    public void Demo() {
        List<String> warnings = new ArrayList<String>();

        boolean overwrite = true;

        //如果这里出现空指针，直接写绝对路径即可。

        String genCfg = "D:\\GZ\\ideaProject\\workSystem\\src\\main\\resources\\mbgconfig.xml";

        File configFile = new File(genCfg);

        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = null;

        try {

            config = cp.parseConfiguration(configFile);

        } catch (Exception e) {

            e.printStackTrace();

        }

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator myBatisGenerator = null;

        try {

            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            myBatisGenerator.generate(null);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Test
    public void Demo2(){
        //查询
        System.out.println(adminMapper);
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin.getAccount());
    }

    @Test
    public void demo3(){
        List<Grade> grades = gradeMapper.selectByExample(new GradeExample());
        System.out.println(((Grade)grades.toArray()[0]));
    }
}
