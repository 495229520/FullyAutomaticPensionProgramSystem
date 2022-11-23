package mvc.bean;

import java.io.Serializable;

/**
 * 包名:mvc.bean
 * 药的类，包含三个信息：一个药的对象的一次服用有三个属性分别是药名，药数，该种药的一次服用时间
 * @author hwf
 * 日期2022-10-2022/10/31   21:10
 */
public class Medicine implements Serializable {
    private int id;
    private int userId;
    private String time;
    private String medicineName;
    private String medicineNum;
//    private String onTime;

//    public String getOnTime() {
//        return onTime;
//    }
//
//    public void setOnTime(String onTime) {
//        this.onTime = onTime;
//    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", medicineNum='" + medicineNum + '\'' +
//                ", onTime='" + onTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineNum() {
        return medicineNum;
    }

    public void setMedicineNum(String medicineNum) {
        this.medicineNum = medicineNum;
    }

    public Medicine() {
    }

    public Medicine(int id, int userId, String time, String medicineName, String medicineNum, String onTime) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.medicineName = medicineName;
        this.medicineNum = medicineNum;
//        this.onTime = onTime;
    }
}
