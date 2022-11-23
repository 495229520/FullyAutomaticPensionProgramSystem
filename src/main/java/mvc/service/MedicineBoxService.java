package mvc.service;

import mvc.bean.MedicineBox;
import mvc.dao.MedicineBoxMapper;
import mvc.dao.UserMapper;

import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/8   23:04
 */
public interface MedicineBoxService {

    /**
     * 添加MedicineBoxMapper
     * @param medicineBoxMapper
     */
    boolean setMedicineBoxMapper(MedicineBoxMapper medicineBoxMapper);

    /**
     * 添加userMapper
     * @param userMapper
     * @return
     */
    boolean setUserMapper(UserMapper userMapper);

    /**
     * 添加老人药盒的信息
     * @param medicineBox
     */
    boolean insertMedicineBox(MedicineBox medicineBox);

    /**
     * 批量添加老人药盒的信息
     * @param medicineBoxList
     */
    boolean insertBathMedicineBox(List<MedicineBox> medicineBoxList);

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
    List<MedicineBox> selectAllMedicineBox();

    /**
     * 根据老人的姓名去寻找药盒信息
     * @param username
     * @return
     */
    MedicineBox selectMedicineBoxByUsername(String username);


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
