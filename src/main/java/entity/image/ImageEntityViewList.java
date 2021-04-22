package entity.image;

import dao.DataBase;
import entity.EntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageEntityViewList {
    private final DataBase dataBase;
    private final int employeeId;

    public ImageEntityViewList(DataBase dataBase, int employeeId) {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
    }

    public List<EntityView> entityViewList() throws SQLException {
        List<EntityView> entityViewList = new ArrayList<>();
        String request = "select * from images where employee_id = " + employeeId + ';';
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            entityViewList.add(new ImageEntityView(resultSet.getString(1)));
        }
        return entityViewList;
    }
}
