package entity.job;

import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

/**
 * Выпадающий список подразделений, где может работать сотрудник.
 */
public class DivisionChoiceBox extends ChoiceBox<DivisionView> {

    public DivisionChoiceBox(){
        this.getItems().add(DivisionView.DEFAULTDIVISION);
        this.getItems().add(DivisionView.ADMINISTRATION);
        this.getItems().add(DivisionView.SUPPLEMENT);
        this.getItems().add(DivisionView.TRANSPORT);
        this.getItems().add(DivisionView.MARKETING);
        this.getItems().add(DivisionView.WORKSHOP3);
        this.getItems().add(DivisionView.WORKSHOP9);
        this.getItems().add(DivisionView.WORKSHOP8);
        this.getItems().add(DivisionView.BSC);
        this.getItems().add(DivisionView.UKANDRP);
        this.getItems().add(DivisionView.STAFFDEPARTMENT);
        this.getItems().add(DivisionView.ECONOMICDEPARTMENT);
        this.getItems().add(DivisionView.CHIEFMECHANICSERVICE);
        this.getItems().add(DivisionView.CONSTRUCTIONDEPARTMENT);
        this.getItems().add(DivisionView.REPAIRBUILDDEPARTMENT);
        this.getItems().add(DivisionView.CHIEFENERGETICSERVICE);
        this.getItems().add(DivisionView.CHIEFENERGETICSERVICE);
        this.getItems().add(DivisionView.LABORATORY);
        this.getItems().add(DivisionView.OTK);
        this.getItems().add(DivisionView.OPIMDEPARTMENT);
        this.getItems().add(DivisionView.ACCOUNTING);
        this.setValue(DivisionView.DEFAULTDIVISION);

        this.setConverter(new StringConverter<DivisionView>() {
            @Override
            public String toString(DivisionView object) {
                return object.toString();
            }

            @Override
            public DivisionView fromString(String string) {
                if (string.equals("администрация")) return DivisionView.ADMINISTRATION;
                if (string.equals("сектор снабжения")) return DivisionView.SUPPLEMENT;
                if (string.equals("транспортный участок")) return DivisionView.TRANSPORT;
                if (string.equals("бюро производства и маркетинга")) return DivisionView.MARKETING;
                if (string.equals("цех №3")) return DivisionView.WORKSHOP3;
                if (string.equals("цех №9")) return DivisionView.WORKSHOP9;
                if (string.equals("цех №8")) return DivisionView.WORKSHOP8;
                if (string.equals("БСЦ")) return DivisionView.BSC;
                if (string.equals("УКиРП")) return DivisionView.UKANDRP;
                if (string.equals("кадровая служба")) return DivisionView.STAFFDEPARTMENT;
                if (string.equals("планово-экономический отдел")) return DivisionView.ECONOMICDEPARTMENT;
                if (string.equals("служба главного механика")) return DivisionView.CHIEFMECHANICSERVICE;
                if (string.equals("технологическо-конструкторское бюро")) return DivisionView.CONSTRUCTIONDEPARTMENT;
                if (string.equals("ремонтно-строительный участок")) return DivisionView.REPAIRBUILDDEPARTMENT;
                if (string.equals("служба главного инженера")) return DivisionView.CHIEFENERGETICSERVICE;
                if (string.equals("служба главного энергетика")) return DivisionView.CHIEFENERGETICSERVICE;
                if (string.equals("лаборатория")) return DivisionView.LABORATORY;
                if (string.equals("ОТК")) return DivisionView.OTK;
                if (string.equals("отдел ОПИМ")) return DivisionView.OPIMDEPARTMENT;
                if (string.equals("бухгалтерия")) return DivisionView.ACCOUNTING;
                return DivisionView.DEFAULTDIVISION;
            }
        });
    }
}
