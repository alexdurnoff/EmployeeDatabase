package card;

import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Карточка сотрудника
 */
public class EmployeeCard extends VBox {
    private final int id;
    public EmployeeCard(int id, List<CardPartition> nodeList) {
        this.id = id;
        FXCollections.observableList(nodeList).forEach(cardPartition ->{
            this.getChildren().add(cardPartition.node());
        });
    }
}
