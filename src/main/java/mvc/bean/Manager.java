package mvc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 包名:mvc.bean
 * 管理人员的bean类
 * @author hwf
 * 日期2022-10-2022/10/22   17:41
 */
public class Manager implements Serializable {

    private int userId;
    private String username;
    private String age;
    private String account;
    private String password;
    private List<User> userList;
    private List<MedicineBox> medicineBoxList;
    private List<Cabinet> cabinetList;
    private List<Time> timeList;

    public Manager(int userId, String username, String age, String account, String password, List<User> userList, List<MedicineBox> medicineBoxList, List<Cabinet> cabinetList, List<Time> timeList) {
        this.userId = userId;
        this.username = username;
        this.age = age;
        this.account = account;
        this.password = password;
        this.userList = userList;
        this.medicineBoxList = medicineBoxList;
        this.cabinetList = cabinetList;
        this.timeList = timeList;
    }

    public Manager() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<MedicineBox> getMedicineBoxList() {
        return medicineBoxList;
    }

    public void setMedicineBoxList(List<MedicineBox> medicineBoxList) {
        this.medicineBoxList = medicineBoxList;
    }

    public List<Cabinet> getCabinetList() {
        return cabinetList;
    }

    public void setCabinetList(List<Cabinet> cabinetList) {
        this.cabinetList = cabinetList;
    }

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userList=" + userList +
                ", medicineBoxList=" + medicineBoxList +
                ", cabinetList=" + cabinetList +
                ", timeList=" + timeList +
                '}';
    }
}
