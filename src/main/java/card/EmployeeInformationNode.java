package card;

import javafx.scene.Node;

/**
 * Часть информации о сотруднике, сгруппированная по соответствующему разделу.
 * Возвращает его методе Node, который будет отображаться в EmployeeCard,
 * или в его детях. Метод update обновляет запись в базе данных.
 */
public interface EmployeeInformationNode {
    Node node();
    update();
}