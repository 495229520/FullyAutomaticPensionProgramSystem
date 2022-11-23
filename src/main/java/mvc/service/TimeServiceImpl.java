package mvc.service;

import mvc.bean.Medicine;
import mvc.bean.Time;
import mvc.bean.User;
import mvc.dao.MedicineMapper;
import mvc.dao.TimeMapper;
import mvc.dao.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/12   13:07
 */
@Service("timeService")
public class TimeServiceImpl implements TimeService{

    private TimeMapper timeMapper;
    private UserMapper userMapper;
    private boolean Confirm;
    private Time time;
    private User user;
    private List<Time> timeList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Time>[] timeListArr;

    @Override
    public TimeMapper setTimeMapper(TimeMapper timeMapper) {
        this.timeMapper = timeMapper;
        return this.timeMapper;
    }

    @Override
    public UserMapper setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
        return this.userMapper;
    }

    @Override
    public int selectId(int id) {
        int num = timeMapper.selectId(id);
        return num;
    }

    @Override
    public boolean insertTime(Time time) {
        Confirm = timeMapper.insertTime(time);
        return Confirm;
    }

    @Override
    public boolean insertBathTime(List<Time> timeList) {
        Confirm = timeMapper.insertBathTime(timeList);
        return Confirm;
    }

    @Override
    public boolean deleteTime(Time time) {
        Confirm = timeMapper.deleteTime(time);
        return Confirm;
    }

    @Override
    public boolean updateTime(Time time) {
        Confirm = timeMapper.updateTime(time);
        return Confirm;
    }

    @Override
    public boolean updateBathTime(List<Time> timeList) {
        Confirm = timeMapper.updateBathTime(timeList);
        return Confirm;
    }

    @Override
    public List<Time> selectTime(int userId) {
        timeList = timeMapper.selectTime(userId);
        return timeList;
    }

    @Override
    public List<Time> selectBathTime() {
        timeList = timeMapper.selectBathTime();
        return timeList;
    }

    @Override
    public List<Time>[] selectTimeByUsername(String username) {
        userList = userMapper.selectUserByUsername(username);
        List<Time>[] timeListArray= new List[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            timeListArray[i] = this.selectTime(userList.get(i).getUserId());
        }
        return timeListArray;
    }
}