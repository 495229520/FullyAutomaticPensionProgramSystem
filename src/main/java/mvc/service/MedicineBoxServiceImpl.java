package mvc.service;

import mvc.bean.MedicineBox;
import mvc.bean.User;
import mvc.dao.MedicineBoxMapper;
import mvc.dao.MedicineMapper;
import mvc.dao.UserMapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/8   23:05
 */
@Service("medicineBoxService")
public class MedicineBoxServiceImpl implements MedicineBoxService {
    private MedicineBoxMapper medicineBoxMapper;
    private UserMapper userMapper;
    private User user = new User();
    private List<User>[] userListArr;
    private List<User> userList;
    private boolean Confirm;
    private MedicineBox medicineBox;
    private List<MedicineBox> medicineBoxList = new ArrayList<>();

    @Override
    public boolean setMedicineBoxMapper(MedicineBoxMapper medicineBoxMapper) {
        this.medicineBoxMapper = medicineBoxMapper;
        return false;
    }

    @Override
    public boolean setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
        return false;
    }

    @Override
    public boolean insertMedicineBox(MedicineBox medicineBox) {
        Confirm = false;
        Confirm = medicineBoxMapper.insertMedicineBox(medicineBox);
        return Confirm;
    }

    @Override
    public boolean insertBathMedicineBox(List<MedicineBox> medicineBoxList) {
        Confirm = false;
        Confirm = medicineBoxMapper.insertBathMedicineBox(medicineBoxList);
        return Confirm;
    }

    @Override
    public boolean deleteMedicineBox(MedicineBox medicineBox) {
        Confirm = false;
        Confirm = medicineBoxMapper.deleteMedicineBox(medicineBox);
        return Confirm;
    }

    @Override
    public boolean updateMedicineBox(MedicineBox medicineBox) {
        Confirm = false;
        Confirm = medicineBoxMapper.updateMedicineBox(medicineBox);
        return Confirm;
    }

    @Override
    public boolean updateBathMedicineBox(List<MedicineBox> medicineBoxList) {
        Confirm = false;
        Confirm = medicineBoxMapper.updateBathMedicineBox(medicineBoxList);
        return Confirm;
    }

    @Override
    public List<MedicineBox> selectAllMedicineBox() {
        List<MedicineBox> medicineBoxList = new ArrayList<>();
        List<MedicineBox> medicineBoxList1 = new ArrayList<>();
//        查药盒的id
        medicineBoxList = medicineBoxMapper.selectAllMedicineBoxNum();
        for (int i = 0; i < medicineBoxList.size(); i++) {
            medicineBoxList1.add(medicineBoxMapper.selectMedicineBox(medicineBoxList.get(i)));
        }
        return medicineBoxList1;
    }

    @Override
    public MedicineBox selectMedicineBoxByUsername(String username) {
        MedicineBox medicineBox = new MedicineBox();
        User user = new User();
        user.setUsername(username);
        userList = userMapper.selectUserByUsername(username);
        return null;
    }

    @Override
    public List<MedicineBox> selectAllMedicineBoxNum() {
        medicineBoxList = null;

        List<MedicineBox> medicineBoxList = medicineBoxMapper.selectAllMedicineBoxNum();
        int[] allMedicineBoxNum = new int[medicineBoxList.size()];
        int i  =  0;
        for (MedicineBox box : medicineBoxList) {
            allMedicineBoxNum[i] = box.getMedicineBoxNum();
            i++;
        }

        for (int i1 : allMedicineBoxNum) {
            System.out.println(i1);
        }

        for (int j = 0; j < medicineBoxList.size(); j++) {
            medicineBox.setMedicineBoxNum(allMedicineBoxNum[j]);
            medicineBox.setUserId(allMedicineBoxNum[j]);
            if (medicineBoxMapper.selectMedicineBox(medicineBox) != null) {
                System.out.println(medicineBoxMapper.selectMedicineBox(medicineBox));
            }else{
                System.out.println(allMedicineBoxNum[j] + "号药盒还没有被使用");
            }
        }
        medicineBoxList = medicineBoxMapper.selectAllMedicineBoxNum();
        return medicineBoxList;
    }

    @Override
    public MedicineBox simpleSelectMedicineBox(MedicineBox medicineBox) {
        this.medicineBox = null;
        this.medicineBox = medicineBoxMapper.simpleSelectMedicineBox(medicineBox);
        return medicineBox;
    }

    @Override
    public MedicineBox selectMedicineBox(MedicineBox medicineBox) {
        this.medicineBox = null;
        this.medicineBox = medicineBoxMapper.selectMedicineBox(medicineBox);
        return this.medicineBox;
    }
}
