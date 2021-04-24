package card;

import dao.DataBase;
import entity.EntityView;
import entity.document.DocumentEntityViewList;

import java.sql.SQLException;
import java.util.List;

/**
 * Раздел информации в карточке сотрудника о его документах
 */
public class DocumentCardPartition extends EmployeeCardPartition{
    private final List<EntityView> entityViewList;

    public DocumentCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
        this.entityViewList = new DocumentEntityViewList(dataBase, this.employeeId).entityViewList();
    }

    @Override
    protected String table() {
        return "documents";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return this.entityViewList;
    }
}
