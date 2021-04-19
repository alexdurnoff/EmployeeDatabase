package entity;

import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Класс инкапсулирует подразделение сотрудника.
 * Реализует интерфейс Predicate<Division> для фильтрации списка.
 */
public enum Division implements Predicate<Division> {
    ADMINISTRATION("администрация"),
    SUPPLEMENT("сектор снабжения"),
    TRANSPORT("транспортный участок"),
    MARKETING("бюро производства и маркетинга"),
    WORKSHOP3("цех №3"),
    WORKSHOP9("цех №9"),
    WORKSHOP8("цех №8"),
    BSC("БСЦ"),
    UKANDRP("УКиРП"),
    STAFFDEPARTMENT("кадровая служба"),
    ECONOMICDEPARTMENT("планово-экономический отдел"),
    CHIEFMECHANICSERVICE("служба главного механика"),
    CONSTRUCTIONDEPARTMENT("технологическо-конструкторское бюро"),
    REPAIRBUILDDEPARTMENT("ремонтно-строительный участок"),
    CHIEFENGENIERSERVICE("служба главного инженера"),
    CHIEFENERGETICSERVICE("служба главного энергетика"),
    LABORATORY("лаборатория"),
    OTK("ОТК"),
    OPIMDEPARTMENT("отдел ОПИМ"),
    ACCOUNTING("бухгалтерия"),
    DEFAULTDIVISION("Подразделение")
    ;

    private final String title;
    private final ChoiceBox<Division> choiceBox;

    Division(String title) {
        this.title = title;
        this.choiceBox = new ChoiceBox<>();
    }


    /**
     *
     * @param division - Division, с которым сравнивается наше подразделение.
     * @return true, если подразделение совпадает с нашим, или если прилетело
     * DEFAULTDIVISION.
     */
    @Override
    public boolean test(Division division) {
        if (division == DEFAULTDIVISION) return true;
        return this == division;
    }


    @Override
    public String toString() {
        return this.title;
    }

    public static Division divisionByName(String name){
        Division[] values = Division.values();
        for (Division value : values) {
            if (value.title.equals(name)) return value;
        }
        return Division.DEFAULTDIVISION;
    }

    public ChoiceBox<Division> choiceBox(){
        choiceBox.getItems().addAll(Arrays.asList(Division.values()));
        choiceBox.setConverter(new StringConverter<Division>() {
            @Override
            public String toString(Division object) {
                return object.title;
            }

            @Override
            public Division fromString(String string) {
                return Division.divisionByName(string);
            }
        });
        choiceBox.setValue(this);
        return choiceBox;
    }
}
