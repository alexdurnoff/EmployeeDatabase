package org.example.ui;

import card.EmployeeCard;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HeaderEmployeeHBox extends HBox {
    private final EmployeeCard employeeCard;

    public HeaderEmployeeHBox(EmployeeCard employeeCard) {
        this.employeeCard = employeeCard;
        this.getChildren().add(new Label(employeeCard.header()));
        this.getChildren().add(employeeCard.saveButton());
    }
}
