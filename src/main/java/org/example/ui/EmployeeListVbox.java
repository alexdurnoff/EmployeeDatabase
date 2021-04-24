package org.example.ui;

import dao.DataBase;
import dao.DefaultEmployeeList;
import entity.employee.Employee;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.example.ui.filters.FilterList;
import org.example.ui.filters.FilterPane;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListVbox extends VBox {
    private final DataBase dataBase;
    private final FilterPane filterPane;

    public EmployeeListVbox(DataBase dataBase) throws SQLException {
        this.dataBase = dataBase;
        this.filterPane = new FilterPane(new FilterList(dataBase).filterList(), this);
        defaultView();
    }

    /**
     * Дефолтный вид VBox
     * @throws SQLException - бросает исключение приработе с базой данных.
     */
    public void defaultView() throws SQLException {
        this.getChildren().clear();
        this.getChildren().add(filterPane);
        List<Employee> employeeList = new DefaultEmployeeList(dataBase).employeeList();
        fill(employeeList);
    }

    /**
     * Фильтрованный вид.
     * @throws SQLException - бросает исключение приработе с базой данных.
     */
    public void filterView() throws SQLException {
        List<Integer> employeeIdList = filterPane.employeeIdList();
        this.getChildren().clear();
        this.getChildren().add(filterPane);
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> defaultEmployeeList = new DefaultEmployeeList(dataBase).employeeList();
        for (Employee employee : defaultEmployeeList) {
            if (employeeIdList.contains(employee.getId())) employeeList.add(employee);
        }
        fill(employeeList);
    }

    /**
     * Заполнение VBox.
     * @param employeeList - список Employee.
     */
    private void fill(List<Employee> employeeList){
        employeeList.forEach(employee -> {
            this.getChildren().add(employee.hBox(dataBase, this));
        });
    }
}
