package mvc.dao;

import mvc.bean.Medicine;
import mvc.bean.MedicineBox;

import java.util.List;

/**
 * 包名:mvc.dao
 *
 * @author hwf
 * 日期2022-10-2022/10/25   22:33
 */
public interface MedicineBoxMapper {

    /**
     * 添加老人药盒的信息
     * @param medicineBox
     */
    boolean insertMedicineBox(MedicineBox medicineBox);

    /**
     * 批量添加老人药盒的信息
     * @param medicineList
     */
    boolean insertBathMedicineBox(List<MedicineBox> medicineList);

    /**
     * 删除老人药盒信息
     * @param medicineBox
     */
    boolean deleteMedicineBox(MedicineBox medicineBox);

    /**
     * 根据id修改老人药盒信息
     * @param medicineBox
     */
    boolean updateMedicineBox(MedicineBox medicineBox);

    /**
     * 批量修改老人药盒信息
     * @param medicineBoxList
     */
    boolean updateBathMedicineBox(List<MedicineBox> medicineBoxList);

    /**
     * 查找所有的老人药盒
     * @param
     */
    List<MedicineBox> selectMedicineBox();

    /**
     * 根据username查向对应的username
     * @param medicineBox
     * @return
     */
    MedicineBox selectMedicineBoxByUsername(MedicineBox medicineBox);

    /**
     * 查找所有老人药盒的编号
     * @return
     */
    List<MedicineBox> selectAllMedicineBoxNum();

    /**
     * 单独查询药盒有无信息
     * 如果userId为 0 就表示目前没有人占用
     * 如果userId不为0 就表示已经有人占用了
     * @return
     */
    MedicineBox simpleSelectMedicineBox(MedicineBox medicineBox);

    /**
     * 根据老人药盒id查找药盒id
     * @param medicineBox
     */
    MedicineBox selectMedicineBox(MedicineBox medicineBox);
}
