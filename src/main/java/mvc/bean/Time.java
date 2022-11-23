package mvc.bean;

import java.io.Serializable;

/**
 * 包名:mvc.bean
 *
 * @author hwf
 * 日期2022-11-2022/11/3   22:14
 */
public class Time implements Serializable {
    private int id;
    private int userId;
    private String time;
    private int onTime;

    public Time(int id, int userId, String time, int onTime) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.onTime = onTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOnTime() {
        return onTime;
    }

    public void setOnTime(int onTime) {
        this.onTime = onTime;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                ", onTime=" + onTime +
                '}';
    }
}

