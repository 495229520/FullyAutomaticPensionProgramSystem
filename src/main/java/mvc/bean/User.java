package mvc.bean;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 包名:mvc.bean
 * 用户信息的bean类
 * @author hwf
 * 日期2022-10-2022/10/22   17:17
 */

public class User implements Serializable {
    //老人信息
    private int userId;
    private String username;
    private String gender;
    private String age;
    private String telephoneNumber;
    //紧急联系人
    private String emergencyContacts;
    //紧急联系人电话号码
    private String emergency_contacts_telephoneNumber;

    //药物信息
    //分配的药盒
    private MedicineBox medicineBox;
    //一次服药种类，数量和时间
    private List<Medicine> medicineList;
    //各个时间段的分药情况
    private List<Time> timeList;

    public User(int userId, String username, String gender, String age, String telephoneNumber, String emergencyContacts, String emergency_contacts_telephoneNumber, List<Medicine> medicineList, MedicineBox medicineBox, List<Time> timeList) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.emergencyContacts = emergencyContacts;
        this.emergency_contacts_telephoneNumber = emergency_contacts_telephoneNumber;
        this.medicineList = medicineList;
        this.medicineBox = medicineBox;
        this.timeList = timeList;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", emergencyContacts='" + emergencyContacts + '\'' +
                ", emergency_contacts_telephoneNumber='" + emergency_contacts_telephoneNumber + '\'' +
                ", medicineList=" + medicineList +
                ", medicineBox=" + medicineBox +
                ", timeList=" + timeList +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(String emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public String getEmergency_contacts_telephoneNumber() {
        return emergency_contacts_telephoneNumber;
    }

    public void setEmergency_contacts_telephoneNumber(String emergency_contacts_telephoneNumber) {
        this.emergency_contacts_telephoneNumber = emergency_contacts_telephoneNumber;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public MedicineBox getMedicineBox() {
        return medicineBox;
    }

    public void setMedicineBox(MedicineBox medicineBox) {
        this.medicineBox = medicineBox;
    }

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }
}
