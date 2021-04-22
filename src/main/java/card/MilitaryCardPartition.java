package card;

import dao.DataBase;
import entity.EntityView;
import entity.military.MilitaryEntityViewList;
import javafx.scene.Node;

import java.sql.SQLException;
import java.util.List;

/**
 * Раздел информации в карточке сотрудника о его воинском учете.
 */
public class MilitaryCardPartition extends EmployeeCardPartition{


    public MilitaryCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
    }

    @Override
    protected String table() {
        return "military";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return new MilitaryEntityViewList(this.dataBase, this.employeeId).militaryEntityList();
    }
}
