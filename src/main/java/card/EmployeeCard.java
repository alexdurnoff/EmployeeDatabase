package card;

import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Карточка сотрудника
 */
public class EmployeeCard extends VBox {
    private final int id;
    public EmployeeCard(int id, List<EmployeeInformationNode> nodeList) {
        this.id = id;
        FXCollections.observableList(nodeList).forEach(employeeInformationNode ->{
            this.getChildren().add(employeeInformationNode.node());
        });
    }
}
