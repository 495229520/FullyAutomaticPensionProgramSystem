package mvc.service;

import mvc.bean.User;
import mvc.dao.MedicineBoxMapper;
import mvc.dao.MedicineMapper;
import mvc.dao.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/7   22:31
 */
@Service("userService")
public class UserServiceImpl implements UserService{

//    业务层调用dao层
    private UserMapper userMapper;
    private MedicineMapper medicineMapper;
    private MedicineBoxMapper medicineBoxMapper;
    private User user = new User();
    Boolean Confirm;
    int ConfirmInt;

    @Override
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public void setMedicineBoxMapper(MedicineBoxMapper medicineBoxMapper) {
        this.medicineBoxMapper = medicineBoxMapper;
    }

    @Override
    public void setMedicineMapper(MedicineMapper medicineMapper) {
        this.medicineMapper = medicineMapper;
    }

    @Override
    public void setUser(User user){
        this.user = user;
    }

    @Override
    public boolean insertUser(User user) {
        Confirm = false;
        Confirm = userMapper.insertUser(user);
        return Confirm;
    }

    @Override
    public boolean insertBathUser(List<User> userList) {
        Confirm = false;
        Confirm = userMapper.insertBathUser(userList);
        return Confirm;
    }

    @Override
    public boolean updateUser(User user) {
        Confirm = false;
        Confirm = userMapper.updateUser(user);
        return Confirm;
    }

    @Override
    public boolean deleteUser(User user) {
        Confirm = false;
        Confirm = userMapper.deleteUser(user);
        return Confirm;
    }

    @Override
    public int selectCount() {
        ConfirmInt = 0;
        ConfirmInt = userMapper.selectCount();
        return ConfirmInt;
    }

    @Override
    public User selectUser(User user) {
        this.user = null;
        this.user = userMapper.selectUser(user);
        return this.user;
    }

    @Override
    public List<User> selectUserByUsername(String username) {
        List<User> userList = userMapper.selectUserByUsername(username);
        List<User> userList1 = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            userList1.add(this.selectUser(userList.get(i)));
        }
        return userList1;
    }

    @Override
    public List<User> selectBathUser() {
        int userNum = userMapper.selectCount();
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < userNum; i++) {
            user.setUserId(i+1);
            if (userMapper.selectUser(user) != null) {
                userList.add(userMapper.selectUser(user));
            }else {
//                提示用户不存在
                System.out.println("当前用户不存在");
            }
        }
        return userList;
    }

    @Override
    public List<User> selectSimpleUser() {
        List<User> userList = new ArrayList<>();
        userList = userMapper.selectSimpleUser();
        return userList;
    }

}
