package mvc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 包名:mvc.bean
 *
 * @author hwf
 * 日期2022-11-2022/11/3   21:04
 */
public class MedicineBox implements Serializable {
    //药盒的编号
    private int medicineBoxNum;
    //用户的id
    private int userId;
    //用户的各种信息
    private User user;
    //是否派送
    private int deliver;
    //一次服药种类，数量和时间
    private List<Medicine> medicineList;
    //各个时间段的分药情况
    private List<Time> timeList;

    public MedicineBox(int medicineBoxNum, int userId, User user, int deliver, List<Medicine> medicineList, List<Time> timeList) {
        this.medicineBoxNum = medicineBoxNum;
        this.userId = userId;
        this.user = user;
        this.deliver = deliver;
        this.medicineList = medicineList;
        this.timeList = timeList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public MedicineBox() {
    }

    public int getMedicineBoxNum() {
        return medicineBoxNum;
    }

    public void setMedicineBoxNum(int medicineBoxNum) {
        this.medicineBoxNum = medicineBoxNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDeliver() {
        return deliver;
    }

    public void setDeliver(int deliver) {
        this.deliver = deliver;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    @Override
    public String toString() {
        return "MedicineBox{" +
                "medicineBoxNum=" + medicineBoxNum +
                ", userId=" + userId +
                ", user=" + user +
                ", deliver=" + deliver +
                ", medicineList=" + medicineList +
                ", timeList=" + timeList +
                '}';
    }
}
