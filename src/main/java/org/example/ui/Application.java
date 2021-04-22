package org.example.ui;

import dao.DataBase;
import dao.DataBaseImpl;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DataBase dataBase = new DataBaseImpl();
        EmployeeListVbox employeeListVbox = new EmployeeListVbox(dataBase);
        Scene scene = new Scene(employeeListVbox, 1300, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Программа учета кадров");
        primaryStage.show();
    }
}
