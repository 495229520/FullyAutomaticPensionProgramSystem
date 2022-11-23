package mvc.service;

import mvc.bean.Time;
import mvc.dao.TimeMapper;
import mvc.dao.UserMapper;

import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/12   13:07
 */
public interface TimeService {

    /**
     * 查询Time的id
     * @param id
     * @return
     */
    int selectId(int id);

    /**
     * 添加TimeMapper
     * @param timeMapper
     * @return
     */
    TimeMapper setTimeMapper(TimeMapper timeMapper);

    /**
     * 添加UserMapper
     * @param userMapper
     * @return
     */
    UserMapper setUserMapper(UserMapper userMapper);

    /**
     * 添加服药时间信息
     * @param time
     * @return
     */
    boolean insertTime(Time time);

    /**
     * 批量添加服药时间信息
     * @param timeList
     * @return
     */
    boolean insertBathTime(List<Time> timeList);

    /**
     * 删除时间
     * @param time
     * @return
     */
    boolean deleteTime(Time time);

    /**
     * 修改修改服药时间信息
     * @param time
     * @return
     */
    boolean updateTime(Time time);

    /**
     * 批量修改服药时间信息
     * @param timeList
     * @return
     */
    boolean updateBathTime(List<Time> timeList);

    /**
     * 通过userId查看服药时间信息
     * @param userId
     * @return
     */
    List<Time> selectTime(int userId);

    /**
     * 查看所有人的服药时间信息
     * @return
     */
    List<Time> selectBathTime();

    /**
     * 通过用户名查找服药时间信息
     * @param username
     * @return
     */
    List<Time>[] selectTimeByUsername(String username);

}
