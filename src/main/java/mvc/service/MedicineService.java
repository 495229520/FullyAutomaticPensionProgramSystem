package mvc.service;

import mvc.bean.Medicine;
import mvc.dao.MedicineMapper;
import mvc.dao.UserMapper;

import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/11   20:14
 */
public interface MedicineService {

    /**
     * 添加UserMapper
     * @param userMapper
     * @return
     */
    public UserMapper setUserMapper(UserMapper userMapper);

    /**
     * 添加MedicineMapper
     * @param medicineMapper
     * @return
     */
    MedicineMapper setMedicineMapper(MedicineMapper medicineMapper);

    /**
     * 添加药物信息
     * @param medicine
     */
    boolean insertMedicine(Medicine medicine);

    /**
     * 批量添加药物信息
     * @param medicineList
     * @return
     */
    boolean bathInsertMedicine(List<Medicine> medicineList);

    /**
     * 删除药物信息
     * @param medicine
     * @return
     */
    boolean deleteMedicine(Medicine medicine);

    /**
     * 修改药物信息
     * @param medicine
     * @return
     */
    boolean updateMedicine(Medicine medicine);

    /**
     * 批量修改药物信息
     * @param medicineList
     * @return
     */
    boolean bathUpdateMedicine(List<Medicine> medicineList);

    /**
     * 根据用户名检查药物信息
     * @param userId
     * @return
     */
    List<Medicine> selectMedicine(int userId);

    /**
     * 查询所有的药
     * @return
     */
    List<Medicine> selectAllMedicine();

    /**
     * 根据名字查找medicine,注意返回的是集合数组
     * @param username
     * @return
     */
    List<Medicine>[] selectMedicineByUsername(String username);
}
