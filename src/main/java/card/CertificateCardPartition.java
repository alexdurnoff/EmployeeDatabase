package card;

import dao.DataBase;
import entity.EntityView;
import entity.certificate.CertificateEntityViewList;

import java.sql.SQLException;
import java.util.List;

public class CertificateCardPartition extends EmployeeCardPartition{

    public CertificateCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
    }

    @Override
    protected String table() {
        return "certificate";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return new CertificateEntityViewList(this.dataBase, this.employeeId).entityViewList();
    }
}
