package mvc.dao;

import mvc.bean.Cabinet;

import java.util.List;

/**
 * 包名:mvc.dao
 * 药柜
 * @author hwf
 * 日期2022-10-2022/10/28   20:28
 */
public interface CabinetMapper {

    /**
     * 批量添加分药柜药盒
     * @param cabinet
     */
     boolean insertBathCabinetBox(List<Cabinet> cabinet);

    /**
     * 添加分药药柜药盒
     * @param cabinet
     */
    boolean insertCabinetBox(Cabinet cabinet);

    /**
     * 删除分药柜药盒
     * @param cabinet
     */
    boolean deleteCabinetBox(Cabinet cabinet);

    /**
     * 修改分药柜药盒
     * @param cabinet
     */
    boolean updateCabinetBox(Cabinet cabinet);

    /**
     * 批量修改分药柜药盒
     * @param cabinetList
     */
    boolean updateBathCabinetBox(List<Cabinet> cabinetList);

    /**
     * 查找分药柜药盒
     * @param cabinet
     */
    Cabinet selectCabinetBox(Cabinet cabinet);

    /**
     * 查找所有的分药药盒
     * @return
     */
    List<Cabinet> selectAllCabinetBox();
}
