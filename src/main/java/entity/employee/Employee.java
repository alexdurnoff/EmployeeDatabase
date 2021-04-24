package entity.employee;

import card.EmployeeCard;
import dao.DataBase;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.example.ui.EmployeeListVbox;

import java.sql.SQLException;

/**
 * Класс Employee. Запись в базе данных о сотруднике.
 * Содержит идентификатор,фамилию, имя, отчество.
 */
public class Employee {
    private final int id;
    private final String name;
    private final String secondName;
    private final String patronymicName;

    public Employee(int id, String name, String secondName, String patronymicName) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
    }

    /**
     * Возвращает HBox, который по требованию пользователя будет показывать карту сотрудника.
     * @param dataBase - база данных. Необходима карте для работы с данными сотрудника.
     * @return - HBox hBox.
     */
    public HBox hBox(DataBase dataBase, EmployeeListVbox employeeListVbox){
        HBox hBox = new HBox();
        hBox.getChildren().add(new Label(secondName));
        hBox.getChildren().add(new Label(name));
        hBox.getChildren().add(new Label(patronymicName));
        hBox.getChildren().add(new Label("идентификатор сотрудника в базе - " + id));
        Button cardShowButton = new Button("Карта сотруднка");
        Button deleteButton = new Button("Удалить");
        cardShowButton.setOnAction(ae -> {
            try {
                new EmployeeCard(id, dataBase, employeeListVbox).show();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        deleteButton.setOnAction(ae -> dataBase.executeUpdateRequest(deleteEmployeeRequest()));
        hBox.getChildren().add(cardShowButton);
        hBox.getChildren().add(deleteButton);
        return hBox;
    }

    /**
     * Запрос на удаление сотрудника из базы данных.
     * @return String request.
     */
    private String deleteEmployeeRequest() {
        return "delete from employee where employee_id = " + id;
    }

    /**
     * Сравнение всех сотрудников происходит только по идентификатору.
     * @param obj Object, с которым сравниваем.
     * @return boolean true, if object equals this. Else return false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Employee.class) return false;
        Employee employee = (Employee) obj;
        return employee.id == this.id;
    }

    public int getId() {
        return id;
    }
}
