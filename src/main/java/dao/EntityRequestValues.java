package dao;

import entity.EntityView;

import java.util.List;

/**
 * Класс инскапсулирует список EntityViewList и возвращает строку значений values
 * для sql-запроса на добавление нового пользователя.
 */
public class EntityRequestValues {
    private final int employeeId;
    private final List<EntityView> entityViewList;

    public EntityRequestValues(int employeeId, List<EntityView> entityViewList) {
        this.employeeId = employeeId;
        this.entityViewList = entityViewList;
    }

    /**
     * Метод возвращает строку значений для sql-запроса на добавление пользователя.
     * @return String values.
     */
    public String values(){
        StringBuilder stringBuilder = new StringBuilder(" values (");
        stringBuilder.append("'").append(employeeId).append("',");
        for (EntityView entityView : entityViewList){
            stringBuilder
                    .append(" '")
                    .append(entityView.insertRequestValue())
                    .append("',");
        }
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(",")) + ") ";
    }
}
