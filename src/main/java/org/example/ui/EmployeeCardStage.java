package org.example.ui;

import card.EmployeeCard;
import javafx.stage.Stage;

import java.util.Optional;

public class EmployeeCardStage extends Stage {
    private final EmployeeCardScene employeeCardScene;
    private final int employeeId;


    public EmployeeCardStage(EmployeeCardScene employeeCardScene,
                             int employeeId) {
        this.employeeCardScene = employeeCardScene;
        this.employeeId = employeeId;
        this.setTitle("Карточка сотрудника №" + employeeId);
        this.setScene(this.employeeCardScene);

    }
}
