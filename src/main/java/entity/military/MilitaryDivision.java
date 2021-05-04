package entity.military;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.util.Arrays;


/**
 * Клосс инкапсулирует воинский состав(профиль).
 * Реализует Predicate<MilitaryDivision> для фильтрации списка.
 * Возвращает выбранное пользователем значение.
 */
public enum MilitaryDivision implements EntityView {
    MEDICAL("медицинский"),
    COMMAND("командный"),
    SOLDIER("солдаты"),
    SAILOR("матрос"),
    DEFAULTMILITARYDIVISION("воинский состав(профиль)");

    private final String title;
    private final ChoiceBox<MilitaryDivision> choiceBox;


    MilitaryDivision(String string) {
        this.title = string;
        this.choiceBox = new ChoiceBox<>();
    }

    public static MilitaryDivision divisionByTitle(String title){
        MilitaryDivision[] values = values();
        for (MilitaryDivision value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTMILITARYDIVISION;
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("воинский состав");
        this.choiceBox.getItems().addAll(Arrays.asList(values()));
        this.choiceBox.setConverter(new StringConverter<MilitaryDivision>() {
            @Override
            public String toString(MilitaryDivision object) {
                return object.title;
            }

            @Override
            public MilitaryDivision fromString(String string) {
                return divisionByTitle(string);
            }
        });
        this.choiceBox.setValue(this);
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    /**
     * Выбранное пользователем значение.
     * @return - MilitaryRank, выбранное в ChoiceBox.
     */
    private MilitaryDivision userChoice(){
        return this.choiceBox.getValue();
    }

    @Override
    public String requestPart() {
        return "set military_division = " +
                "'" +
                this.userChoice().title +
                "'";
    }

    @Override
    public String insertRequestValue() {
        return this.userChoice().title;
    }

    @Override
    public String column() {
        return "military_division";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
