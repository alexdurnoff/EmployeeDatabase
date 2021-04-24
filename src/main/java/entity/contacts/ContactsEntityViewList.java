package entity.contacts;

import dao.DataBase;
import entity.EntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactsEntityViewList {
    private final List<EntityView> contactsEntityViewList;
    private final DataBase dataBase;
    private final int employeeId;

    public ContactsEntityViewList(DataBase dataBase, int employeeId) {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
        this.contactsEntityViewList = new ArrayList<>();
    }

    public List<EntityView> contactsEntityViewList() throws SQLException {
        this.contactsEntityViewList.clear();
        String request = "select * from contacts where employee_id = " + employeeId;
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            this.contactsEntityViewList.add(new Adress(resultSet.getString(1)));
            this.contactsEntityViewList.add(new WorkPhone(resultSet.getString(2)));
            this.contactsEntityViewList.add(new HomePhone(resultSet.getString(3)));
            this.contactsEntityViewList.add(new Email(resultSet.getString(4)));
        }
        return this.contactsEntityViewList;
    }

    /**
     * Список для добавления нового сотрудника
     * @return List<EntityView>
     */
    public List<EntityView> defaultList() {
        this.contactsEntityViewList.clear();
        this.contactsEntityViewList.add(new Adress(""));
        this.contactsEntityViewList.add(new WorkPhone(""));
        this.contactsEntityViewList.add(new HomePhone(""));
        this.contactsEntityViewList.add(new Email(""));
        return this.contactsEntityViewList;
    }
}
