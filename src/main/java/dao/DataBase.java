package dao;

import java.sql.ResultSet;

public interface DataBase {
    void executeUpdateRequest(String request);
    ResultSet getResultSet(String request);
}
