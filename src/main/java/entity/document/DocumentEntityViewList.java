package entity.document;

import dao.DataBase;
import entity.EntityView;
import entity.employee.EmployeeName;
import entity.employee.EmployeePatronymicNameView;
import entity.employee.EmployeeSecondNameView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        this.documentEntityViewList.clear();
        String request = "select * from documents where employee_id = " + employeeId;
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            this.documentEntityViewList.add(new EmployeeName(resultSet.getString(2)));
            this.documentEntityViewList.add(new EmployeePatronymicNameView(resultSet.getString(10)));
            this.documentEntityViewList.add(new EmployeeSecondNameView(resultSet.getString(3)));
            this.documentEntityViewList.add(new BirthDate(resultSet.getString(4)));
            this.documentEntityViewList.add(new DocumentType(resultSet.getString(5)));
            this.documentEntityViewList.add(new DocumentSerialView(resultSet.getString(6)));
            this.documentEntityViewList.add(new DocumentNumber(resultSet.getString(7)));
            this.documentEntityViewList.add(new DocumentPublisher(resultSet.getString(8)));
            this.documentEntityViewList.add(new DocumentReleaseDate(resultSet.getString(9)));
        }
        return documentEntityViewList;
    }

    /**
     * Список для добавления нового сотрудника
     * @return List<EntityView>
     */
    public List<EntityView> defaultList() {
        this.documentEntityViewList.clear();
        this.documentEntityViewList.add(new EmployeeName(""));
        this.documentEntityViewList.add(new EmployeePatronymicNameView(""));
        this.documentEntityViewList.add(new EmployeeSecondNameView(""));
        this.documentEntityViewList.add(new BirthDate(LocalDate.now().toString()));
        this.documentEntityViewList.add(new DocumentType(""));
        this.documentEntityViewList.add(new DocumentSerialView(""));
        this.documentEntityViewList.add(new DocumentNumber("0"));
        this.documentEntityViewList.add(new DocumentPublisher(""));
        this.documentEntityViewList.add(new DocumentReleaseDate(LocalDate.now()));
        return documentEntityViewList;
    }
}
