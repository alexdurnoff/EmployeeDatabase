package org.example.ui;

import card.EmployeeCard;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public class EmployeeCardBorderPane extends BorderPane {

    public EmployeeCardBorderPane(CardPartitionsScrollPane scrollPane, EmployeeCard employeeCard) {
        this.setTop(new HeaderEmployeeHBox(employeeCard));
        this.setCenter(scrollPane);
    }
}
