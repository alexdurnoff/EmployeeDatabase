package entity;

import javafx.scene.layout.GridPane;

/**
 * Вьюшка для получения от пользователя данных по определенному
 * полю
 */
public interface EntityView {
    /**
     * Добавление в соответствующую таблицу
     * @param gridPane - таблица в разделе карточки сотрудника
     */
    void addToGridPane(GridPane gridPane, int rowNumber);

    /**
     * Возвращает часть строки для формирования
     * sql-запроса в базу.
     * @return String часть строки запроса.
     */
    String requestPart();
}
