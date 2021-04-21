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
    private final List<EntityView> entityViewList;
    protected final int employeeId;
    private final String table;
    protected final DataBase dataBase;

    public EmployeeCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        this.dataBase = dataBase;
        this.entityViewList = entityViewList();
        this.employeeId = employeeId;
        this.table = table();
    }

    protected abstract String table();

    protected abstract List<EntityView> entityViewList() throws SQLException;

    @Override
    public Node node() {
        GridPane gridPane = new GridPane();
        int rowNumber = 0;
        for (EntityView entityView : entityViewList) {
            entityView.addToGridPane(gridPane, rowNumber++);
        }
        return gridPane;
    }

    @Override
    public void update() {
        this.dataBase.executeUpdateRequest(
                new RequestByEntityViewList(
                        table,
                        employeeId,
                        entityViewList
                ).request()
        );
    }
}
