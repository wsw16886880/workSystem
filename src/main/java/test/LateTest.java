package test;

import com.worksystem.entity.Late;
import com.worksystem.service.LateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class LateTest {

    @Autowired
    private LateService lateService;

    @Test
    public void demo1() {
        Late late = new Late();
        late.setLdate(new Date(System.currentTimeMillis()));
        late.setLedate(new Date(System.currentTimeMillis()+(1000*60*60*24*7)));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        System.out.println(dateFormat.format(late.getLdate()));
        System.out.println(dateFormat.format(late.getLedate()));
        java.util.Date date = new java.util.Date(System.currentTimeMillis()+(1000*60*60*24*7));
        System.out.println(dateFormat.format(date));
    }

    @Test
    public void demo2() {
//        List<Late> lates = lateService.selectByGid(1);
//        System.out.println(lates);

        Late late = new Late();
        late.setLsid(90);
        late.setLweek(12);
        late.setLwid(28);
        String fileName = lateService.getFileName(late);
        System.out.println(fileName);
    }
}
