package mvc.test;

import mvc.bean.*;
import mvc.dao.*;
import mvc.service.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名:mvc.test
 *
 * @author hwf
 * 日期2022-11-2022/11/8   16:55
 */
public class TestMVC {
    private SqlSession session;
    ApplicationContext context =
            new ClassPathXmlApplicationContext("bean/loadBean.xml");
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    List<User> userList = new ArrayList<>();
    List<Cabinet> cabinetList = new ArrayList<>();
    List<MedicineBox> medicineBoxList = new ArrayList<>();
    private List<Time>[] timeListArr;

    @Test
    public void TestTimeService() throws IOException{
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        TimeMapper timeMapper = session.getMapper(TimeMapper.class);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        TimeService service = (TimeService) ac.getBean("timeService");
        Time time = context.getBean("time",Time.class);
        List<Time> timeList = new ArrayList<>();

        service.setTimeMapper(timeMapper);
        service.setUserMapper(userMapper);

//        添加一个time
//        System.out.println(service.insertTime(time));

//        添加多个time
        timeList.add(context.getBean("time2",Time.class));
        timeList.add(context.getBean("time1",Time.class));
//        System.out.println(service.insertBathTime(timeList));

//        根据用户id和时间删除时间
//         service.deleteTime(context.getBean("time",Time.class));

//        根据用户名和用户id更新time
//        System.out.println(service.updateTime(context.getBean("time1",Time.class)));

//        批量更新用户名和用户id
//        System.out.println(service.updateBathTime(timeList));

//        timeList = service.selectTime(1);
//        for (Time time1 : timeList) {
//            System.out.println(time1);
//        }
//        System.out.println("=======================");

//        通过userId查找时间
//        Time tim1 = new Time();
//        tim1.setUserId(2);
//        System.out.println(timeMapper.selectTime(1));

//        通过用户名查找服药时间信息
        List<Time>[] timeListArray= new List[userList.size()];
        timeListArray = service.selectTimeByUsername("张三");
        for (List<Time> times : timeListArray) {
            for (Time time1 : times) {
                System.out.println(time1);
            }
        }

        session.commit();
        session.close();
    }

    @Test
    public void  TestMedicineService() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        MedicineMapper medicineMapper = session.getMapper(MedicineMapper.class);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        MedicineService service = (MedicineService) ac.getBean("medicineService");
        Medicine medicine = context.getBean("medicine1",Medicine.class);
        List<Medicine> medicineList = new ArrayList<>();

        service.setMedicineMapper(medicineMapper);
        service.setUserMapper(userMapper);

//        根据姓名查看是否服药
//        List<Medicine>[] medicineListArr = service.selectMedicineByUsername("张三");
//        for (List<Medicine> medicineList : medicineListArr) {
//            for (Medicine medicine : medicineList) {
//                System.out.println(medicine);
//            }
//        }

//        查找所有的药
//        List<Medicine> medicineList = service.selectAllMedicine();
//        for (Medicine medicine : medicineList) {
//            System.out.println(medicine);
//        }

//        根据id查询药
//        List<Medicine> medicineList = service.selectMedicine(1);
//        for (Medicine medicine1 : medicineList) {
//            System.out.println(medicine1);
//        }

//          更新药
//        System.out.println(medicine);
//        boolean Confirm = medicineMapper.updateMedicine(medicine);
//        System.out.println(Confirm);

//        添加药
//        System.out.println(service.insertMedicine(medicine));

//        medicineList.add(context.getBean("medicine",Medicine.class));
//        medicineList.add(context.getBean("medicine1",Medicine.class));
//        批量添加药
//        service.bathInsertMedicine(medicineList);

//        删除药
//        System.out.println(service.deleteMedicine(medicine));

        session.commit();
        session.close();
    }

    @Test
    public void TestMedicineBoxService() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        MedicineBoxMapper medicineBoxMapper = session.getMapper(MedicineBoxMapper.class);
        MedicineBoxService service = (MedicineBoxService) ac.getBean("medicineBoxService");
        service.setMedicineBoxMapper(medicineBoxMapper);
        MedicineBox medicineBox = context.getBean("medicineBox",MedicineBox.class);
        MedicineBox medicineBox1 = context.getBean("medicineBox1",MedicineBox.class);
        medicineBoxList.add(medicineBox);
        medicineBoxList.add(medicineBox1);

//        添加药盒
//        System.out.println(service.insertMedicineBox(medicineBox1));
//        批量添加药盒
//        System.out.println(service.insertBathMedicineBox(medicineBoxList));
//        删除药盒
//        System.out.println(service.deleteMedicineBox(medicineBox));
//        更新药盒
//        System.out.println(service.updateMedicineBox(medicineBox1));
//        批量更新药盒
//        if(service.updateBathMedicineBox(medicineBoxList) == false){
//            System.out.println("修改失败，该药盒编号不存在");
//        }else {
//            System.out.println("成功修改");
//        }
//
//        查看药盒信息
//        System.out.println(service.selectMedicineBox(medicineBox));

//        查找所有的药盒
        List<MedicineBox> medicineBoxList = service.selectAllMedicineBox();
        for (MedicineBox box : medicineBoxList) {
            System.out.println(box);
        }

        session.commit();
        session.close();
    }

    @Test
    public void TestCabinetService() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        CabinetMapper cabinetMapper = session.getMapper(CabinetMapper.class);
        CabinetService service = (CabinetService) ac.getBean("cabinetService");
        service.setCabinetMapper(cabinetMapper);
        Cabinet cabinet = context.getBean("cabinet1",Cabinet.class);
        Cabinet cabinet1 = context.getBean("cabinet",Cabinet.class);
        cabinetList.add(cabinet);
        cabinetList.add(cabinet1);

//      添加一个分药药盒
//        System.out.println(service.insertCabinetBox(context.getBean("cabinet", Cabinet.class)));

//      添加多个分药药盒
//        cabinetList.add(context.getBean("cabinet",Cabinet.class));
//        cabinetList.add(context.getBean("cabinet1",Cabinet.class));
//        System.out.println(service.insertBathCabinetBox(cabinetList));

//        删除一个药盒
//        if (service.deleteCabinetBox("王五")==false){
//            System.out.println("分药药盒没有保存此类药物");
//        }else {
//            System.out.println("删除成功");
//        }

//        更新药盒
//        System.out.println(service.updateCabinetBox(cabinet));

//        批量更新药盒
//        System.out.println(service.updateBathCabinetBox(cabinetList));

//        查看药盒
//        cabinet.setTypeOfMedication("伏特加");
//        System.out.println(service.selectCabinetBox(cabinet));
//        System.out.println(service.selectCabinetBoxByUsername("美汁源"));

//        查看所有的药盒
        cabinetList = service.selectAllCabinetBox();
        for (Cabinet cabinet2 : cabinetList) {
            System.out.println(cabinet2);
        }

        session.commit();
        session.close();
    }

    @Test
    public void TestUserService() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        UserService service = (UserService) ac.getBean("userService"); // 因为给service起了别名，所以通过id的方式获取class
        service.setUserMapper(userMapper);

//        批量查看的功能
//        userList = service.selectBathUser();
//        for (User user : userList) {
//            System.out.println(user);
//        }

//        查询用户的信息
//        System.out.println(service.selectUser(context.getBean("user1", User.class)));

//        插入功能
//        User user = context.getBean("user2", User.class);
//            System.out.println(service.insertUser(user));

//        批量插入
//        userList.add(context.getBean("user1",User.class));
//        userList.add(context.getBean("user2",User.class));
//        System.out.println(service.insertBathUser(userList));

//        修改
//        System.out.println(userMapper.updateUser(user));

//        删除用户的信息
//        System.out.println(userMapper.deleteUser(user));

//        检查所有的注册用户
//        userList = userMapper.selectSimpleUser();
//        for (User user1 : userList) {
//            System.out.println(user1);
//        }

//        根据用户名查找user
        List<User> userList = service.selectUserByUsername("张三");
        for (User user : userList) {
            System.out.println(user);
        }

//        int i = userMapper.selectCount();
//        System.out.println(i);

        session.commit();
        session.close();
    }
}
