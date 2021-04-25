package dao;

import entity.EntityView;

import java.util.List;

/**
 * Класс инскапсулирует список EntityViewList и возвращает строку столбцов columns
 * для sql-запроса на добавление нового пользователя.
 */
public class EntityRequestColumns {
    private final List<EntityView> entityViewList;
    public EntityRequestColumns(List<EntityView> entityViewList) {
        this.entityViewList = entityViewList;
    }

    public String columns() {
        StringBuilder stringBuilder = new StringBuilder(" (employee_id,");
        for (EntityView entityView : entityViewList){
            stringBuilder
                    .append(' ')
                    .append(entityView.column())
                    .append(',');
        }
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(",")) + ")";
    }
}
