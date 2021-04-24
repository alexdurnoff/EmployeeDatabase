package dao;

import java.sql.*;

public class DataBaseImpl implements DataBase {
    private final Connection connection;
    private final String url = "jdbc:sqlite:employee.sqlite3";

    public DataBaseImpl() throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    @Override
    public void executeUpdateRequest(String request) {
        System.out.println(request);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(request);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("exception in request: " + request);
        }
    }

    @Override
    public ResultSet getResultSet(String request) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
