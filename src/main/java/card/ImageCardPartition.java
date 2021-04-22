package card;

import dao.DataBase;
import entity.EntityView;
import entity.image.ImageEntityViewList;

import java.sql.SQLException;
import java.util.List;

public class ImageCardPartition extends EmployeeCardPartition {

    public ImageCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
    }

    @Override
    protected String table() {
        return "image";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return new ImageEntityViewList(this.dataBase, this.employeeId).entityViewList();
    }
}
