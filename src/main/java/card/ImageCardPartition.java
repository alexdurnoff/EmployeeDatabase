package card;

import dao.DataBase;
import entity.EntityView;
import entity.image.ImageEntityViewList;

import java.sql.SQLException;
import java.util.List;

public class ImageCardPartition extends EmployeeCardPartition {
    private final List<EntityView> entityViewList;

    public ImageCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
        this.entityViewList = new ImageEntityViewList(this.dataBase, this.employeeId).entityViewList();
    }

    @Override
    protected String table() {
        return "images";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return this.entityViewList;
    }

    @Override
    public void insertNewEmployee() throws SQLException {

    }
}
