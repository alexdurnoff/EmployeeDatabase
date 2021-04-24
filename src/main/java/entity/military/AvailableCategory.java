package entity.military;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Класс инкапсулирует гтовность к воинской службе.
 * Реализует интерфейс Predicate<AvailableCategory> для фильтрации списка.
 * Возвращает выбранное пользователем значение.
 */
public enum AvailableCategory implements EntityView, Predicate<AvailableCategory> {
    G("Г"),
    GO("ГО"),
    VN("ВН"),
    NGM("НГМ"),
    NGI("НГИ"),
    GNS("ГНС"),
    IND("ИНД"),
    DEFAULTCATEGORY("категория готовности");

    private final String title;
    private final ChoiceBox<AvailableCategory> choiceBox;

    AvailableCategory(String string) {
        this.title = string;
        this.choiceBox = new ChoiceBox<>();
    }

    public static AvailableCategory categoryByTitle(String string) {
        AvailableCategory[] values = values();
        for (AvailableCategory value : values) {
            if (value.title.equals(string)) return value;
        }
        return DEFAULTCATEGORY;
    }

    /**
     * Выбранное пользователем значение.
     * @return - AvailableCategory, выбранное в ChoiceBox.
     */
    private AvailableCategory userChoice(){
        return this.choiceBox.getValue();
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("категория готовности к воинской службе");
        this.choiceBox.getItems().addAll(Arrays.asList(values()));
        this.choiceBox.setConverter(new StringConverter<AvailableCategory>() {
            @Override
            public String toString(AvailableCategory object) {
                return object.title;
            }

            @Override
            public AvailableCategory fromString(String string) {
                return categoryByTitle(string);
            }
        });
        this.choiceBox.setValue(this);
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set available_category = " +
                "'" +
                this.userChoice().title +
                "'";
    }

    @Override
    public String insertRequestValue() {
        return null;
    }

    @Override
    public boolean test(AvailableCategory availableCategory) {
        if (availableCategory == DEFAULTCATEGORY) return true;
        return this == availableCategory;
    }
}
