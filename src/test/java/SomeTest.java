import edu.tongji.comm.example.enums.UniversityEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen on 2017/7/14.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class SomeTest {

    public void testEnum() {
        int code = 1;
        UniversityEnum.getUniversityEnum(1);
    }


    /**
     * 测试spring bean的init-method和destroy-method
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        System.out.println("#################################");
        context.close();
    }




}
