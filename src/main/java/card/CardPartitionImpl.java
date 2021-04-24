package card;

import dao.DataBase;
import dao.RequestByEntityViewList;
import entity.EntityView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.List;

public class CardPartitionImpl implements CardPartition{
    private final int employeeId;
    private final String table;
    private final DataBase dataBase;
    private final ObservableList<EntityView> entityViewList;

    public CardPartitionImpl(int employeeId, String table, DataBase dataBase, List<EntityView> entityViewList) {
        this.employeeId = employeeId;
        this.table = table;
        this.dataBase = dataBase;
        this.entityViewList = FXCollections.observableList(entityViewList);
    }


    @Override
    public Node node() throws SQLException {
        GridPane gridPane = new GridPane();
        int rowNumber = 0;
        for (EntityView entityView : entityViewList) {
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
