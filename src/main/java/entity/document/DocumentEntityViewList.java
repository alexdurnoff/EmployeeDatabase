package entity.document;

import dao.DataBase;
import entity.EntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentEntityViewList {
    private final List<EntityView> documentEntityViewList;
    private final DataBase dataBase;
    private final int employeeId;

    public DocumentEntityViewList(DataBase dataBase, int employeeId) {
        this.documentEntityViewList = new ArrayList<>();
        this.dataBase = dataBase;
        this.employeeId = employeeId;
    }

    public List<EntityView> entityViewList() throws SQLException {
        String request = "select * from documents where employee_id = " + employeeId;
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            this.documentEntityViewList.add(new BirthDate(resultSet.getString(1)));
            this.documentEntityViewList.add(new DocumentType(resultSet.getString(2)));
            this.documentEntityViewList.add(new DocumentSerialView(resultSet.getString(3)));
            this.documentEntityViewList.add(new DocumentNumber(resultSet.getString(4)));
            this.documentEntityViewList.add(new DocumentPublisher(resultSet.getString(5)));
            this.documentEntityViewList.add(new DocumentReleaseDate(resultSet.getString(6)));
        }
        return documentEntityViewList;
    }
}
