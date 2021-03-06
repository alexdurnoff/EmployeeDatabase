package card;

import dao.DataBase;
import dao.RequestByEntityViewList;
import entity.EntityView;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.List;

/**
 * Абстрактный класс. Раздел информации о сотруднике в карточке.
 */
public abstract class EmployeeCardPartition implements CardPartition{
    protected final int employeeId;
    private final String table;
    protected final DataBase dataBase;
    private final List<EntityView> entityViewList;

    public EmployeeCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
        this.table = table();
        this.entityViewList = entityViewList();
    }

    protected abstract String table();

    protected abstract List<EntityView> entityViewList() throws SQLException;

    @Override
    public Node node() throws SQLException {
        GridPane gridPane = new GridPane();
        int rowNumber = 0;
        for (EntityView entityView : entityViewList()) {
            entityView.addToGridPane(gridPane, rowNumber);
            rowNumber++;
        }
        return gridPane;
    }

    @Override
    public void update() throws SQLException {
        this.dataBase.executeUpdateRequest(
                new RequestByEntityViewList(
                        table,
                        employeeId,
                        entityViewList
                ).request()
        );
    }
}
