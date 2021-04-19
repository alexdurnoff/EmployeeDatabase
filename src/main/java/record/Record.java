package record;

import javafx.scene.Node;

/**
 * Запись в базе данных.
 */
public interface Record {
    /**
     * Обновляет запись
     */
    void update();

    /**
     * Выдает элемент для добавления в графическое отображение карточки.
     * @return Node - узел, добавляемый в карточку.
     */
    Node node();

    /**
     * Фильтр по записи.
     * @param record - запись в базе данных.
     * @return true, если параметр метода соответствует некоторым условиям,
     * и запись должна остаться в списке.
     */
    boolean filter(Record record);
}
