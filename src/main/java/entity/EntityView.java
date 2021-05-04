package entity;

import hibernate.HibernateEntity;
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
     * sql-запроса в базу для редактирования данных сотрудника.
     * @return String часть строки запроса.
     */
    String requestPart();

    /**
     * Возвращает часть строки для формирования
     * sql-запроса в базу для добавления нового сотрудника.
     * @return String часть строки запроса.
     */
    String insertRequestValue();

    /**
     * Метод возвращает название столбца в таблице базы данных
     * @return String column
     */
    String column();

    HibernateEntity entity();
}
