package mvc.service;

import mvc.bean.Cabinet;
import mvc.dao.CabinetMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名:mvc.service
 *
 * @author hwf
 * 日期2022-11-2022/11/8   16:29
 */
@Service("cabinetService")
public class CabinetServiceImpl implements CabinetService{

    private CabinetMapper cabinetMapper;
    private boolean Confirm;
    private Cabinet cabinet;

    @Override
    public void setCabinetMapper(CabinetMapper cabinetMapper) {
        this.cabinetMapper = cabinetMapper;
    }

    @Override
    public boolean insertBathCabinetBox(List<Cabinet> cabinetList) {
        Confirm = false;
        Confirm = cabinetMapper.insertBathCabinetBox(cabinetList);
        return Confirm;
    }

    @Override
    public boolean insertCabinetBox(Cabinet cabinet) {
        Confirm = false;
        Confirm = cabinetMapper.insertCabinetBox(cabinet);
        return Confirm;
    }

    @Override
    public boolean deleteCabinetBox(String username) {
        Confirm = false;
        Cabinet cabinet = new Cabinet();
        cabinet.setTypeOfMedication(username);
        Confirm = cabinetMapper.deleteCabinetBox(cabinet);
        return Confirm;
    }

    @Override
    public boolean updateCabinetBox(Cabinet cabinet) {
        Confirm = false;
        Confirm = cabinetMapper.updateCabinetBox(cabinet);
        return Confirm;
    }

    @Override
    public boolean updateBathCabinetBox(List<Cabinet> cabinetList) {
        Confirm = false;
        Confirm = cabinetMapper.updateBathCabinetBox(cabinetList);
        return Confirm;
    }

    @Override
    public Cabinet selectCabinetBox(Cabinet cabinet) {
        this.cabinet = null;
        this.cabinet = cabinetMapper.selectCabinetBox(cabinet);
        return this.cabinet;
    }

    @Override
    public Cabinet selectCabinetBoxByUsername(String username) {
        Cabinet cabinet = new Cabinet();
        cabinet.setTypeOfMedication(username);
        this.cabinet =  cabinetMapper.selectCabinetBox(cabinet);
        return this.cabinet;
    }

    @Override
    public List<Cabinet> selectAllCabinetBox() {
        List<Cabinet> cabinetList = new ArrayList<>();
        cabinetList = cabinetMapper.selectAllCabinetBox();
        return cabinetList;
    }
}
