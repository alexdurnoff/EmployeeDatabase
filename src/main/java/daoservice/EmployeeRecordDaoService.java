package daoservice;

import dao.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRecordDaoService implements EmployeeRecordService {
    private final DataBase dataBase;
    private final List<Integer> employeeIdList;

    public EmployeeRecordDaoService(DataBase dataBase) throws SQLException {
        this.dataBase = dataBase;
        this.employeeIdList = new ArrayList<>();
        updateEmployeeList();
    }

    private void updateEmployeeList() throws SQLException {
        ResultSet resultSet = dataBase.getResultSet("select * from employee");
        while (resultSet.next()){
            this.employeeIdList.add(resultSet.getInt(1));
        }
    }

    @Override
    public List<Integer> employeeIdList() {

        return null;
    }
}
