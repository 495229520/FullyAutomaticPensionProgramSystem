package mvc.service;

import mvc.bean.Cabinet;
import mvc.dao.CabinetMapper;

import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/8   16:27
 */
public interface CabinetService {

    /**
     * 添加cabinetMapper
     * @param cabinetMapper
     */
    void setCabinetMapper(CabinetMapper cabinetMapper);

    /**
     * 批量添加分药柜药盒
     * @param cabinetList
     */
    boolean insertBathCabinetBox(List<Cabinet> cabinetList);

    /**
     * 添加分药药柜药盒
     * @param cabinet
     */
    boolean insertCabinetBox(Cabinet cabinet);

    /**
     * 删除分药柜药盒
     * @param username
     */
    boolean deleteCabinetBox(String username);

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
     * 根据username查找分药柜药盒
     * @param cabinet
     */
    Cabinet selectCabinetBox(Cabinet cabinet);

    /**
     * 传入username，根据username查询分药药柜
     * @param username
     * @return
     */
    Cabinet selectCabinetBoxByUsername(String username);

    /**
     * 查找所有的分药药盒
     * @return
     */
    List<Cabinet> selectAllCabinetBox();
}
