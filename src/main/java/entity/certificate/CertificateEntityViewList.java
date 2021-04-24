package entity.certificate;

import dao.DataBase;
import entity.EntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificateEntityViewList {
    private final DataBase dataBase;
    private final int employeeId;
    private final List<EntityView> entityViewList = new ArrayList<>();


    public CertificateEntityViewList(DataBase dataBase, int employeeId) {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
    }

    public List<EntityView> entityViewList() throws SQLException {
        this.entityViewList.clear();
        String request = "select * from certificate where employee_id = " + employeeId + ';';
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            this.entityViewList.add(new CertificateCity(resultSet.getString(2)));
            this.entityViewList.add(new CertificateOrganization(resultSet.getString(3)));
            this.entityViewList.add(new Qualification(
                    resultSet.getString(4)));
        }
        return entityViewList;
    }

    /**
     * Список для добавления нового сотрудника
     * @return List<EntityView>
     */
    public List<EntityView> defaultList() {
        this.entityViewList.clear();
        this.entityViewList.add(new CertificateCity(""));
        this.entityViewList.add(new CertificateOrganization(""));
        this.entityViewList.add(new Qualification(""));
        return entityViewList;
    }
}
