package entity.dossier;

import dao.DataBase;
import entity.EntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DossierEntityViewList {
    private final DataBase dataBase;
    private final int employeeId;
    private final List<EntityView> entityViewList = new ArrayList<>();

    public DossierEntityViewList(DataBase dataBase, int employeeId) {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
    }

    public List<EntityView> entityViewList() throws SQLException {
        String request = "select * from dossier where employee_id = " + employeeId +';';
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()) {
            this.entityViewList.add(new DossierEntityView(resultSet.getString(1)));
        }
        return this.entityViewList;
    }
}
