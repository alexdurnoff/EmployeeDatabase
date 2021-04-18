package card;

import javafx.scene.Node;

/**
 * Часть информации о сотруднике, сгруппированная по соответствующему разделу.
 * Возвращает в единственном методе Node, который будет отображаться в EmployeeCard,
 * или в его детях.
 */
public interface EmployeeInformationNode {
    Node node();
}
