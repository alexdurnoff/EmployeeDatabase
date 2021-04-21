package card;

import dao.DataBase;
import entity.EntityView;
import entity.document.DocumentEntityViewList;

import java.sql.SQLException;
import java.util.List;

public class DocumentCardPartition extends EmployeeCardPartition{
    public DocumentCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
    }

    @Override
    protected String table() {
        return "documents";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return new DocumentEntityViewList(dataBase, employeeId).entityViewList();
    }
}
