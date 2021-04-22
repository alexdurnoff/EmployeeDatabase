package org.example.ui;

import dao.DataBase;
import javafx.scene.layout.VBox;

public class EmployeeListVbox extends VBox {
    private final DataBase dataBase;

    public EmployeeListVbox(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
