package org.example.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class EmployeeScrollPaneHeaderHBox extends HBox {
    private final Button addEmployeeButton;

    public EmployeeScrollPaneHeaderHBox(){
        this.addEmployeeButton = new Button("Добавить сотрудника");
        Label label = new Label("Список сотрудников");
        this.getChildren().add(label);
        this.getChildren().add(addEmployeeButton);
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
    }

    public Button getAddEmployeeButton(){
        return this.addEmployeeButton;
    }
}
