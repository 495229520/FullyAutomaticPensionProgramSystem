package mvc.test;

import mvc.bean.*;
import mvc.dao.*;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名:mvc.test
 *
 * @author hwf
 * 日期2022-10-2022/10/23   21:58
 */
@Aspect
@Component
public class TestMybatis{

    private SqlSession session;
    private Object employeeMapper;
    private int MedicineId = 1;
    ApplicationContext context =
            new ClassPathXmlApplicationContext("bean/loadBean.xml");


    /**
     * 根据分药药盒保存的药物名称 查询分药药盒
     * @throws IOException
     */
    @Test
    public void selectCabinetBox() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        CabinetMapper cabinetMapper = session.getMapper(CabinetMapper.class);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");
        Cabinet cabinet = context.getBean("cabinet",Cabinet.class);

        try {
            cabinet = cabinetMapper.selectCabinetBox(cabinet);
        }catch (TooManyResultsException e){
            System.out.println("查找的结果有重复");
        }

        if (cabinet == null){
            System.out.println("查询的结果为空");
        }else{
            System.out.println(cabinet);
        }

        session.commit();
        session.close();
    }

    /**
     * 查询所有的分药药盒
     * @throws IOException
     */
    @Test
    public void selectAllCabinetBox() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        CabinetMapper cabinetMapper = session.getMapper(CabinetMapper.class);
        Cabinet cabinet = new Cabinet();
        List<Cabinet> cabinetList = cabinetMapper.selectAllCabinetBox();
        for (int i = 0; i < cabinetList.size(); i++) {
            cabinet = cabinetList.get(i);
            System.out.println(cabinet);
        }

        session.commit();
        session.close();
    }

    /**
     * 根据分药药盒编号更新分药药盒
     * @throws IOException
     */
    @Test
    public void updateCabinetBox() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        CabinetMapper cabinetMapper = session.getMapper(CabinetMapper.class);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");
        List<Cabinet> cabinetList =  new ArrayList<>();
        cabinetList.add(context.getBean("cabinet",Cabinet.class));
        cabinetList.add(context.getBean("cabinet1",Cabinet.class));
//        根据分药药盒编号更新分药药盒
//        cabinetMapper.updateCabinetBox(context.getBean("cabinet",Cabinet.class));
//        根据分药药盒编号更新多个药盒
//        cabinetMapper.updateBathCabinetBox(cabinetList);
        session.commit();
        session.close();
    }

    /**
     * 根据药名删除药盒
     * @throws IOException
     */
    @Test
    public void deleteCabinetBox() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        CabinetMapper cabinetMapper = session.getMapper(CabinetMapper.class);

        List<Cabinet> cabinetList = new ArrayList<>();
        cabinetList.add(context.getBean("cabinet",Cabinet.class));
        cabinetList.add(context.getBean("cabinet1",Cabinet.class));
        cabinetList.add(context.getBean("cabinet2",Cabinet.class));
        cabinetMapper.deleteCabinetBox(context.getBean("cabinet",Cabinet.class));

        session.commit();
        session.close();
    }

    /**
     * 增加分药药盒
     * @throws IOException
     */
    @Test
    public void insertCabinetBox() throws IOException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        CabinetMapper cabinetMapper = session.getMapper(CabinetMapper.class);

        List<Cabinet> cabinetList = new ArrayList<Cabinet>();
        cabinetList.add(context.getBean("cabinet",Cabinet.class));
        cabinetList.add(context.getBean("cabinet1",Cabinet.class));
//      增加多个
//        cabinetMapper.insertBathCabinetBox(cabinetList);
//      增加一个
        cabinetMapper.insertCabinetBox(context.getBean("cabinet",Cabinet.class));

        session.commit();
        session.close();
    }


    /**
     * 管理员账号的删除
     * @throws IOException
     */
    @Test
    public void deleteManager() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        ManagerMapper managerMapper = session.getMapper(ManagerMapper.class);

        Manager manager = context.getBean("manager",Manager.class);

        managerMapper.deleteManager(manager);

        session.commit();
        session.close();
    }

    @Test
    public void selectAllManager() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        ManagerMapper managerMapper = session.getMapper(ManagerMapper.class);

        Manager manager = new Manager();
        manager = context.getBean("manager",Manager.class);
        System.out.println(managerMapper.selectManager(manager));

        List<Manager> managerList = managerMapper.selectAllManager();
        for (int i = 0; i < managerList.size(); i++) {
//            System.out.println(managerList.get(i));
        }

        session.commit();
        session.close();
    }

    @Test
    public void updateManager() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        ManagerMapper managerMapper = session.getMapper(ManagerMapper.class);

        Manager manager = context.getBean("manager",Manager.class);

        managerMapper.updateManager(manager);

        session.commit();
        session.close();
    }

    @Test
    public void selectManager() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        ManagerMapper managerMapper = session.getMapper(ManagerMapper.class);

        Manager manager = context.getBean("manager",Manager.class);
        System.out.println(managerMapper.selectManager(manager));
        session.commit();
        session.close();
    }

    /**
     * 管理员账号的添加
     * @throws IOException
     */
    @Test
    public void insertManager() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");
        //获取Mapper对象
        ManagerMapper managerMapper = session.getMapper(ManagerMapper.class);
        Manager manager = context.getBean("manager",Manager.class);
        System.out.println(managerMapper.insertManager(manager));

        List<Manager> managerList = new ArrayList<>();
        managerList.add(context.getBean("manager2",Manager.class));
        managerList.add(context.getBean("manager3",Manager.class));

//        managerMapper.insertBathManager(managerList);

        session.commit();
        session.close();
    }

    /**
     * 药盒的增删改查
     * @throws IOException
     */
    @Test
    public void testMedicineBox() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();

        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");

        MedicineBoxMapper medicineBoxMapper = session.getMapper(MedicineBoxMapper.class);
        MedicineBox medicineBox = context.getBean("medicineBox", MedicineBox.class);
//        System.out.println(medicineBox.getUserId());

//        List<Time> timeList = new ArrayList<>();
//        timeList = medicineBoxMapper.selectMedicineBox(medicineBox).getTimeList();

        List<MedicineBox> medicineBoxList = new ArrayList<>();
        medicineBoxList.add(context.getBean("medicineBox",MedicineBox.class));
        medicineBoxList.add(context.getBean("medicineBox1",MedicineBox.class));

//        增加单个药盒
//        medicineBoxMapper.insertMedicineBox(context.getBean("medicineBox",MedicineBox.class));
//        增加多个药盒
//        medicineBoxMapper.insertBathMedicineBox(medicineBoxList);
//        更新药盒
//        medicineBoxMapper.updateBathMedicineBox(medicineBoxList);
//        删除药盒
//        medicineBoxMapper.deleteMedicineBox(context.getBean("medicineBox",MedicineBox.class));
//        根据userId和medicineNum查询药盒
//        System.out.println(medicineBoxMapper.selectMedicineBox(medicineBox));

        //根据username查询药盒
//        MedicineBox medicineBox = new MedicineBox();
//        User user = new User();
//        user.setUsername("张三");
//        medicineBox.setUser(user);
//        System.out.println(medicineBoxMapper.selectMedicineBoxByUsername(medicineBox));
//        MedicineBox medicineBox1 = medicineBoxMapper.selectMedicineBoxByUsername(medicineBox);
//        System.out.println(medicineBoxMapper.selectMedicineBox(medicineBox1));

        //查询多个药盒


//        medicineBox.setMedicineBoxNum(medicineBox);
//        System.out.println(medicineBoxMapper.selectMedicineBox(medicineBox));


//        查找所有的老人药盒
//        List<MedicineBox> medicineBoxList = medicineBoxMapper.selectAllMedicineBoxNum();
//        int[] allMedicineBoxNum = new int[medicineBoxList.size()];
//        int i  =  0;
//        for (MedicineBox box : medicineBoxList) {
//            allMedicineBoxNum[i] = box.getMedicineBoxNum();
//            i++;
//        }
//
//        for (int i1 : allMedicineBoxNum) {
//            System.out.println(i1);
//        }
//
//        for (int j = 0; j < medicineBoxList.size(); j++) {
//            medicineBox.setMedicineBoxNum(allMedicineBoxNum[j]);
//            medicineBox.setUserId(allMedicineBoxNum[j]);
//            if (medicineBoxMapper.selectMedicineBox(medicineBox) != null) {
//                System.out.println(medicineBoxMapper.selectMedicineBox(medicineBox));
//            }else{
//                System.out.println(allMedicineBoxNum[j] + "号药盒还没有被使用");
//            }
//        }

        session.commit();
        session.close();
    }

    /**
     * 时间的增删改查
     * @throws IOException
     */
    @Test
    public void testTime() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();

        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");

        TimeMapper timeMapper = session.getMapper(TimeMapper.class);

//        Time time = context.getBean("time",Time.class);
//        List<Time> timeList = new ArrayList<>();
//        timeList.add(context.getBean("time",Time.class));
//        timeList.add(context.getBean("time1",Time.class));
//        timeList.add(context.getBean("time2",Time.class));
//        插入单个time
//        timeMapper.insertTime(time);
//        插入多个time
//        timeMapper.insertBathTime(timeList);
//        删除
//        timeMapper.deleteTime(context.getBean("time",Time.class));
//        更新time
//        timeMapper.updateTime(context.getBean("time",Time.class));
//        更新一个人的所有ontime
//        timeMapper.updateBathTime(context.getBean("time",Time.class));

//        查看一个人的所有time
        List<Time> timeList = timeMapper.selectTime(1);
        for (Time time : timeList) {
            System.out.println(time);
        }

//        查看所有人的time
//        List<Time> timeList = timeMapper.selectBathTime();
//        for (Time time : timeList) {
//            System.out.println(time);
//        }

        session.commit();
        session.close();
    }

    /**
     * 用户的增删改查
     * @throws IOException
     */
    @Test
    public void testUser() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        //获取Mapper对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");

        int userId = 2;
        User user = context.getBean("user2",User.class);
        System.out.println(user.getUsername());
        List<User> userList = new ArrayList<>();
        userList.add(context.getBean("user1",User.class));
        userList.add(context.getBean("user2",User.class));

//        添加用户信息
//        System.out.println(userMapper.insertUser(user));
//        批量添加用户信息
//        userMapper.insertBathUser(userList);
//        查单个
        User userById = userMapper.selectUser(user);
        System.out.println(userById);
//        删除用户的信息
//        userMapper.deleteUser(context.getBean("user2",User.class));
//        更新用户的信息
//        userMapper.updateUser(user);
//        简单查询所哟的注册用户
//            userList = userMapper.selectSimpleUser();
//        for (User user1 : userList) {
//            System.out.println(user1);
//        }

//        查询所有的用户信息
//        int userNum = userMapper.selectCount();
//        for (int i = 0; i < userNum; i++) {
//            user.setUserId(i+1);
//            if (userMapper.selectUser(user) != null) {
//                System.out.println(userMapper.selectUser(user));
//            }else {
//                System.out.println("当前用户不存在");
//            }
//        }
//        System.out.println("------");
//        List<User> userList1 = userMapper.selectUserByUsername("张三");
//        for (User user1 : userList1) {
//            System.out.println(user1);
//        }

        session.commit();
        session.close();
    }

//    @Test
//    public void testFindAllUser() throws IOException{
//        session = new SqlSessionFactoryBuilder().
//                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
//        //获取Mapper对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//
//        List<User> userlist = userMapper.findAllUser();
//
//        for (User user:userlist) {
//            System.out.println(userlist);
//        }
//
//        session.commit();
//        session.close();
//    }
//
//    @Test
//    public void  testDeleteUser() throws IOException {
//        session = new SqlSessionFactoryBuilder().
//                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
//        //获取Mapper对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//
//        User user = new User();
//        user.setUserId(4);
//        userMapper.deleteUser(user);
//
//        session.commit();
//        session.close();
//    }
//
//    @Test
//    public void testUpdateByMap() throws IOException {
//        session = new SqlSessionFactoryBuilder().
//                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
//
//        //获取Mapper对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//
//        String [] args1 = {"1","2","3","4","5"};
//        String [] args2 = {"1","2","3","4","5"};
//        String [] args3 = {"1","2","3","4","5"};
//        String [] args4 = {"1","2","3","4","5"};
//
//        User user = new User(2,"4","4","55","57756","2","3",args1,args2,"4",args3,args4);
//
//        //获取Mapper对象
//        UserMapper userMapper1 = session.getMapper(UserMapper.class);
//
//        userMapper.updateUser(user);
//
//        session.commit();
//        session.close();
//    }
//
//    @Test
//    public void testAddUser() throws IOException {
//        session = new SqlSessionFactoryBuilder().
//                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
//        //获取Mapper对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        //药物的集合
//        List<Medicine> medicineList = new ArrayList<>();
//        for (int i = 1; i < 4; i++) {
//            medicineList.add(new Medicine(i,1,"8:00","阿司匹林"+i,"3"));
//        }
//
//        for (int i = 4; i < 7; i++) {
//            medicineList.add(new Medicine(i,1,"12:00","利血平"+i,"3"));
//        }
//
//        //药盒的集合
//        MedicineBox medicineBox = new MedicineBox(1,1,"张三1",medicineList,true);
//
//        List<User> userList = new ArrayList<>();
//        for (int i = 1; i < 2; i++) {
//            userList.add(new User(i,"张三"+i,"男","81","120","李四","110",medicineList));
//        }
//
//        User user = new User(10,"2","3","4","5","2","3",args1,args2,"4",args3,args4);
//
//        session = new SqlSessionFactoryBuilder().
//                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
//
//        //获取Mapper对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//
//        for (int i = user.getUserId(); i < 50; ) {
//            userMapper.addUser(user);
//            user.setUserId(++i);
//        }
//
//        session.commit();
//        session.close();
//    }

    /**
     * 药物的增删改查
     * @throws IOException
     */
    @Test
    public void testMedicine() throws IOException {
        session = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean/loadBean.xml");
        //获取Mapper对象
        MedicineMapper medicineMapper = session.getMapper(MedicineMapper.class);
        Medicine medicine = new Medicine();
        medicine = context.getBean("medicine",Medicine.class);

        MedicineId = 22;
        int staticMedicineId = MedicineId;

//        Medicine medicine = new Medicine(1,1,"8:00","阿司匹林","3");
//        System.out.println(medicineMapper.insertMedicine(medicine));

//        测试增加的功能
//        List<Medicine> medicineList = new ArrayList<>();
//        for (int i = MedicineId; i < staticMedicineId+3; i++) {
//            medicineList.add(new Medicine(i,3,"8:00","阿司匹林"+i,"3"));
//            MedicineId++;
//        }
//
//        for (int i = MedicineId; i < staticMedicineId+6; i++) {
//            medicineList.add(new Medicine(i,3,"12:00","利血平"+i,"3"));
//            MedicineId++;
//        }
//
//        for (int i = MedicineId; i < staticMedicineId+9; i++) {
//            medicineList.add(new Medicine(i,3,"18:00","血滞通"+i,"3"));
//            MedicineId++;
//        }
//
//        System.out.println(medicineMapper.bathInsertMedicine(medicineList));
//
//        //测试删除功能
//        medicineMapper.deleteMedicine(1);

//        测试修改功能
//        List<Medicine> medicineList = new ArrayList<>();
//        for (int i = MedicineId; i < staticMedicineId+3; i++) {
//            medicineList.add(new Medicine(i,1,"8:00","可口可乐"+i,"3"));
//            MedicineId++;
//        }
//
//        for (int i = MedicineId; i < staticMedicineId+6; i++) {
//            medicineList.add(new Medicine(i,1,"12:00","芬达"+i,"3"));
//            MedicineId++;
//        }
//
//        for (int i = MedicineId; i < staticMedicineId+9; i++) {
//            medicineList.add(new Medicine(i,1,"18:00","美汁源"+i,"3"));
//            MedicineId++;
//        }
//        medicineList.add(context.getBean("medicine",Medicine.class));
//        medicineList.add(context.getBean("medicine1",Medicine.class));
//        System.out.println(medicineMapper.bathUpdateMedicine(medicineList));

//        medicine = context.getBean("medicine",Medicine.class);
        medicineMapper.updateMedicine(medicine);


//        设置添加单个信息
//        medicineMapper.updateMedicine(new Medicine(2,1,"18:00","血滞通","3"));

//        测试查询所有信息
        List<Medicine> medicineList = new ArrayList<>();
        medicineList = medicineMapper.selectAllMedicine();
        for (Medicine medicine1 : medicineList) {
            System.out.println(medicine1);
        }

        //测试查询单个信息
//        User user = context.getBean("user",User.class);
//        System.out.println(user.getUserId());
//        int userId = 3;
//        medicineList = medicineMapper.selectMedicine(userId);
//        for (int i = 0; i < medicineList.size()/9; i++) {
//            System.out.println(medicineList.get(i));
//        }
//        for (Medicine medicine1 : medicineList) {
//            System.out.println(medicine1);
//        }
//        System.out.println(medicineList);
//        for (Medicine medicine1 : medicineList) {
//            System.out.println(medicine1);
//        }

        //测试删除单个药在某个时间点的信息
//        medicine = context.getBean("medicine",Medicine.class);
//        medicineMapper.deleteMedicine(medicine);
//
//        session.commit();
//        session.close();
    }

//    @Test
//    public void testHelloWorldReview() throws IOException {
//
//        //借助Mybatis的Resource类将Mybatis全局配置文件读取到内存中
//        //这里使用的路径依然是是一个以类路径根目录为基准的相对路径
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//        //创建一个SQLSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//
//        //调用builder对象的build()方法来创建SQLSessionFactory，此时需要用到读取了全局配置文件的输入流
//        SqlSessionFactory factory = builder.build(inputStream);
//
//        //调用工厂对象的方法开启一个会话：从java程序到数据库之间的会话
//        SqlSession session = factory.openSession();
//        //浏览器-servlet-service-dao-sql
//
//        //执行Mapper配置文件中准备好的sql语句，想过全局配置文件中mapper的resource读取到镜像配置文件，然后就把镜像配置文件中的内容封装到
//        //一个对象中，那么就可以通过这个对象直接查询到主机想要的信息，这个时候就不是直接寻找配置文件中的信息了
//        //此时执行的查找查找已经不是到xml配置文件中去找了，因为xml配置文件中的信息已经被读取到内存中封装成了对象
//        // 所以现在是到已封装的对象中查找，查找的依据就是Mapper配置文件的namespace值.SQL语句标签的id
//        String statement = "mvc.dao.UserMapper.findUserById";
//        Long userId = 1L;
//        Object o = session.selectOne(statement,userId);
//
//        //打印查询到的结果
//        System.out.println("o = " + o);
//
//        //提交事务
//        session.commit();
//        //关闭session
//        session.close();
//    }



//    /**
//     * Junit会在每一个@Test方法前执行一个@Before方法
//     */
//    @Before("")
//    public void init() throws IOException {
//        session = new SqlSessionFactoryBuilder().
//                build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("bean/loadBean.xml");
//    }
//
//    /**
//     * Junit会在每一个@Test方法后执行@After方法
//     */
//    @After("")
//    public void clear(){
//        session.commit();
//        session.close();
//    }

}
