package mvc.service;

import mvc.bean.Medicine;
import mvc.bean.MedicineBox;
import mvc.bean.User;
import mvc.dao.MedicineBoxMapper;
import mvc.dao.MedicineMapper;
import mvc.dao.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/11   20:14
 */
@Service("medicineService")
public class MedicineServiceImpl implements MedicineService{

    private MedicineMapper medicineMapper;
    private UserMapper userMapper;
    private boolean Confirm;
    private Medicine medicine;
    private User user;

    @Override
    public UserMapper setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
        return userMapper;
    }

    @Override
    public MedicineMapper setMedicineMapper(MedicineMapper medicineMapper) {
        this.medicineMapper = medicineMapper;
        return medicineMapper;
    }

    @Override
    public boolean insertMedicine(Medicine medicine) {
        Confirm = medicineMapper.insertMedicine(medicine);
        return Confirm;
    }

    @Override
    public boolean bathInsertMedicine(List<Medicine> medicineList) {
        Confirm = medicineMapper.bathInsertMedicine(medicineList);
        return Confirm;
    }

    @Override
    public boolean deleteMedicine(Medicine medicine) {
        Confirm = medicineMapper.deleteMedicine(medicine);
        return Confirm;
    }

    @Override
    public boolean updateMedicine(Medicine medicine) {
        Confirm = medicineMapper.updateMedicine(medicine);
        return Confirm;
    }

    @Override
    public boolean bathUpdateMedicine(List<Medicine> medicineList) {
        Confirm = medicineMapper.bathUpdateMedicine(medicineList);
        return Confirm;
    }

    @Override
    public List<Medicine> selectMedicine(int userId) {
        List<Medicine> medicineList = new ArrayList<>();
        medicineList = medicineMapper.selectMedicine(userId);
        List<Medicine> medicineList1 = new ArrayList<>();
        for (int i = 0; i < medicineList.size()/9; i++) {
            medicineList1.add(medicineList.get(i));
        }
        return medicineList1;
    }

    @Override
    public List<Medicine> selectAllMedicine() {
        List<Medicine> medicineList = new ArrayList<>();
        medicineList = medicineMapper.selectAllMedicine();
        List<Medicine> medicineList1 = new ArrayList<>();
        for (Medicine medicine1 : medicineList) {
            medicineList1.add(medicine1);
        }
        return medicineList1;
    }

    @Override
    public List<Medicine>[] selectMedicineByUsername(String username) {
        List<User> userList = userMapper.selectUserByUsername(username);
        List<Medicine> medicineList = new ArrayList<>();
        int [] userId = new int[userList.size()];

        int i = 0;

        for (User user1 : userList) {
            userId[i] = userList.get(i).getUserId();
            i++;
        }

        List<Medicine> [] medicineListArr = new List[userId.length];

        for (int j = 0; j < userId.length; j++) {
            medicineListArr[j] = this.selectMedicine(userId[j]);
        }

        return medicineListArr;
    }
}
