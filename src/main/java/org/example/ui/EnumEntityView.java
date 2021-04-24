package org.example.ui;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

public class EnumEntityView implements EntityView {
    private final EnumEntity entity;
    protected final ChoiceBox<String> choiceBox;

    public EnumEntityView(EnumEntity entity) {
        this.entity = entity;
        this.choiceBox = new ChoiceBox<>();
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label(entity.labelName());
        EnumEntity[] enumEntities = entity.valueArray();
        for (EnumEntity entity1 : enumEntities){
            this.choiceBox.getItems().add(entity1.title());
        }
        this.choiceBox.setValue(entity.title());
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        try {
            return  entity.columnName() + " = '" +
                    choiceBox.getValue() + "'";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String insertRequestValue() {
        return choiceBox.getValue();
    }
}
