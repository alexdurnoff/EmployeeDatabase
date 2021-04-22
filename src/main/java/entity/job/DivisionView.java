package entity.job;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс инкапсулирует подразделение сотрудника.
 * Реализует интерфейс Predicate<Division> для фильтрации списка.
 * Возвращает выбранное пользователем значение.
 */
public enum DivisionView implements Predicate<DivisionView>, EntityView {
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
    private final ChoiceBox<DivisionView> choiceBox;

    DivisionView(String title) {
        this.title = title;
        this.choiceBox = new DivisionChoiceBox();
    }


    /**
     *
     * @param divisionView - Division, с которым сравнивается наше подразделение.
     * @return true, если подразделение совпадает с нашим, или если прилетело
     * DEFAULTDIVISION.
     */
    @Override
    public boolean test(DivisionView divisionView) {
        if (divisionView == DEFAULTDIVISION) return true;
        return this == divisionView;
    }


    @Override
    public String toString() {
        return this.title;
    }

    public static DivisionView divisionByName(String name){
        DivisionView[] values = DivisionView.values();
        for (DivisionView value : values) {
            if (value.title.equals(name)) return value;
        }
        return DivisionView.DEFAULTDIVISION;
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber){
        Label label = new Label("Подразделение");
        this.choiceBox.getItems().addAll(Arrays.asList(values()));
        this.choiceBox.setConverter(new StringConverter<DivisionView>() {
            @Override
            public String toString(DivisionView object) {
                return object.title;
            }

            @Override
            public DivisionView fromString(String string) {
                return divisionByTitle(string);
            }
        });
        this.choiceBox.setValue(this);
        this.choiceBox.setOnAction(ae -> {
            label.setText(choiceBox.getValue().title);
        });
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    private static DivisionView divisionByTitle(String string) {
        List<DivisionView> divisionViews = Arrays.asList(values());
        for (DivisionView divisionView : divisionViews) {
            if (divisionView.title.equals(string)) return divisionView;
        }
        return DEFAULTDIVISION;
    }

    /**
     * Выбор пользователя
     * @return
     */
    public DivisionView usersChoice(){
        return this.choiceBox.getValue();
    }



    @Override
    public String requestPart() {
        return "set division = " +
                "'" +
                this.usersChoice().toString() +
                "'";
    }
}
