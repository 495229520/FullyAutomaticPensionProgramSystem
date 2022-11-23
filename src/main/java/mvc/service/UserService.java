package mvc.service;

import mvc.bean.User;
import mvc.dao.MedicineBoxMapper;
import mvc.dao.MedicineMapper;
import mvc.dao.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-10-2022/10/23   15:32
 */

public interface UserService {

    /**
     * 添加user
     * @param user
     */
    void setUser(User user);

    /**
     * 添加userMapper
     * @param userMapper
     */
     void setUserMapper(UserMapper userMapper);

    /**
     * 添加medicineBoxMapper
     * @param medicineBoxMapper
     */
     void setMedicineBoxMapper(MedicineBoxMapper medicineBoxMapper);

    /**
     * 添加medicineMapper
     * @param medicineMapper
     */
    void setMedicineMapper(MedicineMapper medicineMapper);

        /**
         * 添加用户信息的方法
         * @param user
         */
    boolean insertUser(User user);

    /**
     * 批量添加用户信息
     * @param userList
     * @return
     */
    boolean insertBathUser(List<User> userList);

    /**
     * 修改用户信息的方法
     * @param user
     */
    boolean updateUser(User user);

    /**
     * 根据id 删除用户信息的方法
     * @param user
     */
    boolean deleteUser(User user);

    /**
     * 查找表中用户的数量
     * @return
     */
    int selectCount();

    /**
     * 根据用户id 查询用户信息
     * @param user
     * @return
     */
    User selectUser(User user);

    /**
     * 根据用户名字 查询用户信息，注意只是简单的查
     * @param username
     * @return
     */
    List<User> selectUserByUsername(String username);

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> selectBathUser();

    /**
     * 简单的查询所有用户的信息
     * @return
     */
    List<User> selectSimpleUser();

}
