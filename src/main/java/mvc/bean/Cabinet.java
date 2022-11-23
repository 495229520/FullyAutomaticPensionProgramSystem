package mvc.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 包名:mvc.bean
 *
 * @author hwf
 * 日期2022-10-2022/10/22   22:38
 */
public class Cabinet implements Serializable {
    //药盒的编号
    private int medicineBoxNum;
    //各个种类的服药数量
    private String The_number_of_drugs_taken_for_each_class_of_drugs;
    //服药种类
    private String typeOfMedication;
    //是否成功分药
    private boolean dispensing;

    @Override
    public String toString() {
        return "Cabinet{" +
                "medicineBoxNum=" + medicineBoxNum +
                ", The_number_of_drugs_taken_for_each_class_of_drugs='" + The_number_of_drugs_taken_for_each_class_of_drugs + '\'' +
                ", typeOfMedication='" + typeOfMedication + '\'' +
                ", dispensing=" + dispensing +
                '}';
    }

    public int getMedicineBoxNum() {
        return medicineBoxNum;
    }

    public void setMedicineBoxNum(int medicineBoxNum) {
        this.medicineBoxNum = medicineBoxNum;
    }

    public String getThe_number_of_drugs_taken_for_each_class_of_drugs() {
        return The_number_of_drugs_taken_for_each_class_of_drugs;
    }

    public void setThe_number_of_drugs_taken_for_each_class_of_drugs(String the_number_of_drugs_taken_for_each_class_of_drugs) {
        The_number_of_drugs_taken_for_each_class_of_drugs = the_number_of_drugs_taken_for_each_class_of_drugs;
    }

    public String getTypeOfMedication() {
        return typeOfMedication;
    }

    public void setTypeOfMedication(String typeOfMedication) {
        this.typeOfMedication = typeOfMedication;
    }

    public boolean isDispensing() {
        return dispensing;
    }

    public void setDispensing(boolean dispensing) {
        this.dispensing = dispensing;
    }

    public Cabinet() {
    }

    public Cabinet(int medicineBoxNum, String the_number_of_drugs_taken_for_each_class_of_drugs, String typeOfMedication, boolean dispensing) {
        this.medicineBoxNum = medicineBoxNum;
        The_number_of_drugs_taken_for_each_class_of_drugs = the_number_of_drugs_taken_for_each_class_of_drugs;
        this.typeOfMedication = typeOfMedication;
        this.dispensing = dispensing;
    }
}
