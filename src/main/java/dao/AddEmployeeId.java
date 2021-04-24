package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс будет возвращать номер для нового добавляемого сотрудника.
 */
public class AddEmployeeId {
    private final DataBase dataBase;

    public AddEmployeeId(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public int id() throws SQLException {
        int number = 1;
        ResultSet resultSet = dataBase.getResultSet("select * from documents");
        while (resultSet.next()){
            number++;
        }
        return number;
    }
}
