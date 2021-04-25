package card;

import dao.DataBase;
import entity.EntityView;
import entity.certificate.CertificateEntityViewList;

import java.sql.SQLException;
import java.util.List;

public class CertificateCardPartition extends EmployeeCardPartition{
    private final List<EntityView> entityViewList;

    public CertificateCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
        this.entityViewList = new CertificateEntityViewList(this.dataBase, this.employeeId).entityViewList();
    }

    @Override
    protected String table() {
        return "certificate";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return this.entityViewList;
    }

    @Override
    public void insertNewEmployee() throws SQLException {

    }
}
