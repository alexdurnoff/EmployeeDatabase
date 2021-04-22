package entity.military;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.function.Predicate;

public enum MillitaryRegistration implements EntityView, Predicate<MillitaryRegistration> {
    GENERIC("общий"),
    SPECIAL("специальный"),
    DEFAULTREGISTRATION("воинский учет");

    private final String title;
    private final ChoiceBox<MillitaryRegistration> choiceBox;

    MillitaryRegistration(String string) {
        this.title = string;
        this.choiceBox = new ChoiceBox<>();
    }

    public static MillitaryRegistration registrationByTitle(String title){
        MillitaryRegistration[] values = values();
        for (MillitaryRegistration value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTREGISTRATION;
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("воинский учет");
        this.choiceBox.getItems().addAll(Arrays.asList(values()));
        this.choiceBox.setConverter(new StringConverter<MillitaryRegistration>() {
            @Override
            public String toString(MillitaryRegistration object) {
                return object.title;
            }

            @Override
            public MillitaryRegistration fromString(String string) {
                return registrationByTitle(string);
            }
        });
        this.choiceBox.setValue(this);
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    private MillitaryRegistration userChoice(){
        return this.choiceBox.getValue();
    }

    @Override
    public String requestPart() {
        return "set military_registration = " +
                "'" +
                this.userChoice().title +
                "'";
    }

    @Override
    public boolean test(MillitaryRegistration millitaryRegistration) {
        if (millitaryRegistration == DEFAULTREGISTRATION) return true;
        return this == millitaryRegistration;
    }
}
