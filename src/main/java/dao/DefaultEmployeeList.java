package dao;

import entity.employee.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Возвращает дефолтный списко сотрудников.
 */
public class DefaultEmployeeList {
    private final DataBase dataBase;

    public DefaultEmployeeList(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public List<Employee> employeeList() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        String request = "select * from documents";
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            employeeList.add(new Employee(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return employeeList;
    }
}
