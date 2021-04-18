package org.example.ui;

import entity.Division;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

/**
 * Выпадающий список подразделений, где может работать сотрудник.
 */
public class DivisionChoiceBox extends ChoiceBox<Division> {

    public DivisionChoiceBox(){
        this.getItems().add(Division.DEFAULTDIVISION);
        this.getItems().add(Division.ADMINISTRATION);
        this.getItems().add(Division.SUPPLEMENT);
        this.getItems().add(Division.TRANSPORT);
        this.getItems().add(Division.MARKETING);
        this.getItems().add(Division.WORKSHOP3);
        this.getItems().add(Division.WORKSHOP9);
        this.getItems().add(Division.WORKSHOP8);
        this.getItems().add(Division.BSC);
        this.getItems().add(Division.UKANDRP);
        this.getItems().add(Division.STAFFDEPARTMENT);
        this.getItems().add(Division.ECONOMICDEPARTMENT);
        this.getItems().add(Division.CHIEFMECHANICSERVICE);
        this.getItems().add(Division.CONSTRUCTIONDEPARTMENT);
        this.getItems().add(Division.REPAIRBUILDDEPARTMENT);
        this.getItems().add(Division.CHIEFENERGETICSERVICE);
        this.getItems().add(Division.CHIEFENERGETICSERVICE);
        this.getItems().add(Division.LABORATORY);
        this.getItems().add(Division.OTK);
        this.getItems().add(Division.OPIMDEPARTMENT);
        this.getItems().add(Division.ACCOUNTING);
        this.setValue(Division.DEFAULTDIVISION);

        this.setConverter(new StringConverter<Division>() {
            @Override
            public String toString(Division object) {
                return object.toString();
            }

            @Override
            public Division fromString(String string) {
                if (string.equals("администрация")) return Division.ADMINISTRATION;
                if (string.equals("сектор снабжения")) return Division.SUPPLEMENT;
                if (string.equals("транспортный участок")) return Division.TRANSPORT;
                if (string.equals("бюро производства и маркетинга")) return Division.MARKETING;
                if (string.equals("цех №3")) return Division.WORKSHOP3;
                if (string.equals("цех №9")) return Division.WORKSHOP9;
                if (string.equals("цех №8")) return Division.WORKSHOP8;
                if (string.equals("БСЦ")) return Division.BSC;
                if (string.equals("УКиРП")) return Division.UKANDRP;
                if (string.equals("кадровая служба")) return Division.STAFFDEPARTMENT;
                if (string.equals("планово-экономический отдел")) return Division.ECONOMICDEPARTMENT;
                if (string.equals("служба главного механика")) return Division.CHIEFMECHANICSERVICE;
                if (string.equals("технологическо-конструкторское бюро")) return Division.CONSTRUCTIONDEPARTMENT;
                if (string.equals("ремонтно-строительный участок")) return Division.REPAIRBUILDDEPARTMENT;
                if (string.equals("служба главного инженера")) return Division.CHIEFENERGETICSERVICE;
                if (string.equals("служба главного энергетика")) return Division.CHIEFENERGETICSERVICE;
                if (string.equals("лаборатория")) return Division.LABORATORY;
                if (string.equals("ОТК")) return Division.OTK;
                if (string.equals("отдел ОПИМ")) return Division.OPIMDEPARTMENT;
                if (string.equals("бухгалтерия")) return Division.ACCOUNTING;
                return Division.DEFAULTDIVISION;
            }
        });
    }
}
