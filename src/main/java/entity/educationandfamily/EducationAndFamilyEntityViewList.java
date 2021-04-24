package entity.educationandfamily;

import dao.DataBase;
import entity.EntityView;
import org.example.ui.EnumEntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationAndFamilyEntityViewList {
    private final DataBase dataBase;
    private final int employeeId;
    private final List<EntityView> entityViewList;

    public EducationAndFamilyEntityViewList(DataBase dataBase, int employeeId) {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
        this.entityViewList = new ArrayList<>();
    }

    public List<EntityView> entityViewList() throws SQLException {
        String request = "select * from education_and_family where employee_id = " + employeeId;
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            //this.entityViewList.add(new EducationAndFamylyHeader());
            this.entityViewList.add(new EnumEntityView(Education.entityByTitle(resultSet.getString(2))));
            this.entityViewList.add(new EducationInstitute(resultSet.getString(3)));
            this.entityViewList.add(new LanguageEntityView(
                    resultSet.getString(4),
                    resultSet.getString(5))
            );
            this.entityViewList.add(new ChildrenEntityView(
                    resultSet.getString(6),
                    resultSet.getString(7))
            );
            this.entityViewList.add(new InvalidEntityView(
                    resultSet.getString(8),
                    resultSet.getString(9))
            );
            //this.entityViewList.add(new LivingAreaEntityView(resultSet.getString(9)));
        }
        return entityViewList;
    }
}
