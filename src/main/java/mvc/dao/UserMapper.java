package mvc.dao;

import mvc.bean.User;

import java.util.List;

/**
 * 包名:mvc.dao
 *
 * @author hwf
 * 日期2022-10-2022/10/23   14:59
 */
public interface UserMapper {
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
     * 简单的查找数据库中注册的用户数
     * @return
     */
    List<User> selectSimpleUser();

    /**
     * 根据用户名查找用户
     * @return
     */
    List<User> selectUserByUsername(String username);
}
