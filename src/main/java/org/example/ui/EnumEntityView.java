package org.example.ui;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

public class EnumEntityView implements EntityView {
    private final EnumEntity entity;
    private EnumEntity unit;
    protected final ChoiceBox<String> choiceBox;

    public EnumEntityView(EnumEntity entity) {
        this.entity = entity;
        this.choiceBox = new ChoiceBox<>();
        System.out.println("choice box after constructor is " + choiceBox);
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
        System.out.println("choice box before invoke request is " + choiceBox);
        try {
            return  entity.columnName() + " = '" +
                    choiceBox.getValue() + "'";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String ownRequest(){
        return  entity.columnName() + " = '" +
                choiceBox.getValue() + "'";
    }
}
