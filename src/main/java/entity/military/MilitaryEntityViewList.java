package entity.military;

import dao.DataBase;
import entity.EntityView;
import org.example.ui.EnumEntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MilitaryEntityViewList {
    private final DataBase dataBase;
    private final int employeeId;
    private final List<EntityView> militaryEntityViewList = new ArrayList<>();

    public MilitaryEntityViewList(DataBase dataBase, int employeeId) {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
    }

    public List<EntityView> militaryEntityList() throws SQLException {
        String request = "select * from military where employee_id = " + employeeId;
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            //this.militaryEntityViewList.add(new MilitaryHeader());
            this.militaryEntityViewList.add(new EnumEntityView(MilitaryRankEnumEntity.entityByTitle(resultSet.getString(1))));
            this.militaryEntityViewList.add(new EnumEntityView(MilitaryDivisionEnumEntity.entityByTitle(resultSet.getString(2))));
            this.militaryEntityViewList.add(new VUSCodeName(resultSet.getString(3)));
            this.militaryEntityViewList.add(new EnumEntityView(AvailableCategoryEnumEntity.entityByTitle(resultSet.getString(4))));
            this.militaryEntityViewList.add(new MilitaryCommissariat(resultSet.getString(5)));
            this.militaryEntityViewList.add(new EnumEntityView(MilitaryRegistrationEnumEntity.entityByTitle(resultSet.getString(6))));
            this.militaryEntityViewList.add(new RegistrationMark(resultSet.getString(7)));
        }
        return this.militaryEntityViewList;
    }
}
