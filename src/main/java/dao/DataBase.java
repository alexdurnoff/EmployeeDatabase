package dao;

import entity.EmployeeRecord;

import java.util.List;

public interface DataBase {
    List<EmployeeRecord> findAllEmployee();
    void updateEmployee(int id);
    void deleteEmployee(EmployeeRecord employeeRecord);
    void addEmployee(EmployeeRecord employeeRecord);
}
