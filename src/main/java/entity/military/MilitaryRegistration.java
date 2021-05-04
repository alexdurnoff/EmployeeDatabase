package entity.military;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.function.Predicate;

public enum MilitaryRegistration implements EntityView, Predicate<MilitaryRegistration> {
    GENERIC("общий"),
    SPECIAL("специальный"),
    DEFAULTREGISTRATION("воинский учет");

    private final String title;
    private final ChoiceBox<MilitaryRegistration> choiceBox;

    MilitaryRegistration(String string) {
        this.title = string;
        this.choiceBox = new ChoiceBox<>();
    }

    public static MilitaryRegistration registrationByTitle(String title){
        MilitaryRegistration[] values = values();
        for (MilitaryRegistration value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTREGISTRATION;
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("воинский учет");
        this.choiceBox.getItems().addAll(Arrays.asList(values()));
        this.choiceBox.setConverter(new StringConverter<MilitaryRegistration>() {
            @Override
            public String toString(MilitaryRegistration object) {
                return object.title;
            }

            @Override
            public MilitaryRegistration fromString(String string) {
                return registrationByTitle(string);
            }
        });
        this.choiceBox.setValue(this);
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    private MilitaryRegistration userChoice(){
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
    public String insertRequestValue() {
        return this.userChoice().title;
    }

    @Override
    public String column() {
        return "military_registration";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }

    @Override
    public boolean test(MilitaryRegistration militaryRegistration) {
        if (militaryRegistration == DEFAULTREGISTRATION) return true;
        return this == militaryRegistration;
    }
}
