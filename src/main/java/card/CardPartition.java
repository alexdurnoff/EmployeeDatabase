package card;

import dao.DataBase;
import javafx.scene.Node;

import java.sql.SQLException;

/**
 * Часть информации о сотруднике, сгруппированная по соответствующему разделу.
 * Возвращает его методе Node, который будет отображаться в EmployeeCard,
 * или в его детях. Метод update обновляет запись в базе данных.
 */
public interface CardPartition {
    Node node() throws SQLException;
    void update() throws SQLException;
}
