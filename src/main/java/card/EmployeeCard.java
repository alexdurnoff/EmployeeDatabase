package card;

import dao.DataBase;
import javafx.stage.Stage;
import org.example.ui.*;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Карточка сотрудника
 */
public class EmployeeCard {
    private final int employeeId;
    private final CardPartitions cardPartitions;
    private boolean saved;

    public EmployeeCard(int employeeId, DataBase dataBase) {
        this.employeeId = employeeId;
        this.cardPartitions = new EmployeeCardPartitions(dataBase, employeeId);
    }

    public void show() throws SQLException {
        Stage stage = new EmployeeCardStage(
                new EmployeeCardScene(
                        new EmployeeCardBorderPane(
                                new CardPartitionsScrollPane(cardPartitions),
                                this
                        )
                ),
                employeeId
        );
        stage.setOnCloseRequest(ae -> {
            if (! saved){
                Optional<Boolean> optional = new SaveDialog().showAndWait();
                if (optional.isPresent()){
                    if (!optional.get()){
                        try {
                            update();
                        } catch (SQLException ignored) {

                        }
                    }
                }
            }
        });
        stage.show();
    }

    public synchronized boolean isSaved() {
        return saved;
    }

    public synchronized void setSaved(boolean saved) {
        this.saved = saved;
    }

    private void update() throws SQLException {
        this.cardPartitions.cardPartitionList().forEach(CardPartition::update);
        this.setSaved(true);
    }
}
