package mvc.test;

import mvc.bean.User;
import mvc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 包名:mvc.test
 *
 * @author hwf
 * 日期2022-10-2022/10/23   15:35
 */
public class TestUser {


    @Test
    public void testJdbcTemplates(){

        //加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/bean.xml");
        UserService userService = context.getBean("userService",UserService.class);
        String [] args1 = {"1","2","3","4","5"};
        String [] args2 = {"1","2","3","4","5"};
        String [] args3 = {"1","2","3","4","5"};
        String [] args4 = {"1","2","3","4","5"};

//        User user = new User(2,"4","4","55","57756","2","3",args1,args2,"4",args3,args4);
//        userService.addUser(user);

    }
}
