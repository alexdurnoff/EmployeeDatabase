package daoservice;

import entity.EmployeeEntity;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> employeeList() throws SQLException;
    EmployeeEntity findById(int employeeId);
}
