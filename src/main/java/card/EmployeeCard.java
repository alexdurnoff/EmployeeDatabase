package card;

import dao.DataBase;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.ui.*;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Карточка сотрудника
 */
public class EmployeeCard {
    protected final int employeeId;
    protected CardPartitions cardPartitions;
    protected boolean saved;
    protected final EmployeeListVbox employeeListVbox;


    public EmployeeCard(int employeeId, DataBase dataBase, EmployeeListVbox employeeListVbox) throws SQLException {
        this.employeeId = employeeId;
        this.cardPartitions = new EmployeeCardPartitions(dataBase, employeeId);
        this.employeeListVbox = employeeListVbox;
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
                            this.employeeListVbox.defaultView();
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

    protected void update() throws SQLException {
        this.cardPartitions.cardPartitionList().forEach(cardPartition -> {
            try {
                cardPartition.update();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        this.setSaved(true);
    }

    public String header(){
        return "Карточка сотрудника идентификационный номер " + employeeId;
    }

    public Button saveButton(){
        Button saveButton = new Button("Сохранить");
        saveButton.setOnAction(ae -> {
            try {
                update();
                this.employeeListVbox.defaultView();
                setSaved(true);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        return saveButton;
    }
}
