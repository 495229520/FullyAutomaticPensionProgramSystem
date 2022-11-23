package mvc.dao;

import mvc.bean.Medicine;
import mvc.bean.User;

import java.util.List;

/**
 * 包名:mvc.dao
 *
 * @author hwf
 * 日期2022-11-2022/11/2   21:37
 */
public interface MedicineMapper {

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
     * 检查药物信息
     * @param userId
     * @return
     */
    List<Medicine> selectMedicine(int userId);

    /**
     * 查询所有的药
     * @return
     */
    List<Medicine> selectAllMedicine();
}
