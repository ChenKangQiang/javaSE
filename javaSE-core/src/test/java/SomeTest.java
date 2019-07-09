import edu.tongji.comm.example.enums.UniversityEnum;
import edu.tongji.comm.spring.factorybean.Cat;
import edu.tongji.comm.spring.factorybean.Dog;
import edu.tongji.comm.spring.factorybean.Tool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen on 2017/7/14.
 */

public class SomeTest extends BaseUnitTest {

    @Autowired
    private Tool tool;

    @Autowired
    private Object cat;

    @Autowired
    private Object dog;

    /**
     * 测试spring bean的init-method和destroy-method
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("src/main/resources/application-context.xml");
        System.out.println("#################################");
        context.close();
    }


    @Test
    public void test2() {
        System.out.println(tool.getId());
        System.out.println(cat);
        System.out.println(dog);
    }





}
