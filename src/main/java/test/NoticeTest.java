package test;

import org.junit.Test;

import java.sql.Date;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class NoticeTest {

    @Test
    public void demo1(){
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
    }
}
