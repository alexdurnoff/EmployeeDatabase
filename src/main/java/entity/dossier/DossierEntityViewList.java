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
        this.entityViewList.clear();
        String request = "select * from dossier where employee_id = " + employeeId +';';
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()) {
            this.entityViewList.add(new DossierEntityView(resultSet.getString(2)));
        }
        return this.entityViewList;
    }

    /**
     * Список для добавления нового сотрудника
     * @return List<EntityView>
     * @throws SQLException - может генерировать исключение при работе с базой.
     */
    public List<EntityView> defaultList() throws SQLException {
        this.entityViewList.clear();
        String request = "select * from dossier where employee_id = " + employeeId +';';
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()) {
            this.entityViewList.add(new DossierEntityView(""));
        }
        return this.entityViewList;
    }
}
