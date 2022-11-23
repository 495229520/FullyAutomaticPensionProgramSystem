package mvc.dao;

import mvc.bean.Manager;

import java.util.List;

/**
 * 包名:mvc.dao
 *
 * @author hwf
 * 日期2022-10-2022/10/25   22:33
 */
public interface ManagerMapper {

    /**
     * 添加管理员
     * @param
     */
    boolean insertManager(Manager manager);

    /**
     * 批量添加管理员
     * @param managerList
     */
    boolean insertBathManager(List<Manager> managerList);

    /**
     * 查找管理员
     * @param manager
     */
    Manager selectManager(Manager manager);

    /**
     * 修改管理员信息
     * @param manager
     */
    boolean updateManager(Manager manager);

    /**
     * 删除管理员信息
     * @param manager
     */
    boolean deleteManager(Manager manager);

    /**
     * 查看所有的管理员的信息
     */
    List<Manager> selectAllManager();
}
