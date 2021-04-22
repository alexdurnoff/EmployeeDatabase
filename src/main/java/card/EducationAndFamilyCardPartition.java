package card;

import dao.DataBase;
import entity.EntityView;
import entity.educationandfamily.EducationAndFamilyEntityViewList;

import java.sql.SQLException;
import java.util.List;

public class EducationAndFamilyCardPartition extends EmployeeCardPartition {

    public EducationAndFamilyCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
    }

    @Override
    protected String table() {
        return "education_and_family";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return new EducationAndFamilyEntityViewList(this.dataBase, this.employeeId).entityViewList();
    }
}
