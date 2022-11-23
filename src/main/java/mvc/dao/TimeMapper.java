package mvc.dao;

import mvc.bean.Time;

import java.util.List;

/**
 * 包名:mvc.dao
 *
 * @author hwf
 * 日期2022-11-2022/11/3   22:24
 */
public interface TimeMapper {

    /**
     * 查询Time的id
     * @param id
     * @return
     */
    int selectId(int id);

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
     * 查看服药时间信息
     * @param userId
     * @return
     */
    List<Time> selectTime(int userId);

    /**
     * 查看所有人的服药时间信息
     * @return
     */
    List<Time> selectBathTime();

}
