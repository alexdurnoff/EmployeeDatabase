package card;

import dao.DataBase;
import entity.EntityView;
import entity.dossier.DossierEntityViewList;

import java.sql.SQLException;
import java.util.List;

public class DossierCardPartition extends EmployeeCardPartition{

    public DossierCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
    }

    @Override
    protected String table() {
        return "dossier";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return new DossierEntityViewList(this.dataBase, this.employeeId).entityViewList();
    }
}
