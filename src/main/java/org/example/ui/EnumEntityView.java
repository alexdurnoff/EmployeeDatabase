package org.example.ui;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EnumEntityView implements EntityView {
    private final EnumEntity entity;
    private final ChoiceBox<EnumEntity> choiceBox;

    public EnumEntityView(EnumEntity entity) {
        this.entity = entity;
        this.choiceBox = new ChoiceBox<>();
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label(entity.labelName());
        this.choiceBox.getItems().addAll(entity.values());
        this.choiceBox.setConverter(new EnumStringConverter());
        this.choiceBox.setValue(entity);
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set " + entity.columnName() + "'" +
                choiceBox.getValue().title() + "'";
    }
}
