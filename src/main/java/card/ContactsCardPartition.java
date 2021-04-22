package card;

import dao.DataBase;
import entity.EntityView;
import entity.contacts.ContactsEntityViewList;

import java.sql.SQLException;
import java.util.List;

/**
 * Раздел карты сотрудника, отвечающий за контакты.
 */
public class ContactsCardPartition extends EmployeeCardPartition{

    public ContactsCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
    }

    @Override
    protected String table() {
        return "contacts";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return new ContactsEntityViewList(dataBase, employeeId).contactsEntityViewList();
    }
}
