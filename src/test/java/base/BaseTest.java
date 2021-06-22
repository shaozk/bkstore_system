package base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author shaozk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // "src/main/webapp"
@ContextConfiguration(locations = {
        "classpath:spring/springmvc.xml",               // 前端控制器的配置文件
        "classpath:spring/applicationContext.xml" })    // 后端 spring的配置文件
public class BaseTest {

}


