package dao;

import entity.EntityView;

import java.util.List;

/**
 * Класс возвращает строку SQL-update запроса.
 * Инкапсулирует списко EntityView, название таблицы
 * и идентификатор сотрудника.
 */
public class RequestByEntityViewList {
    private final String table;
    private final int employeeId;
    private final List<EntityView> entityViewList;

    public RequestByEntityViewList(String table, int employeeId, List<EntityView> entityViewList) {
        this.table = table;
        this.employeeId = employeeId;
        this.entityViewList = entityViewList;
    }

    public String request(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update ")
                .append(table);
        for (EntityView entityView : entityViewList) {
            stringBuilder.append(' ');
            stringBuilder.append(entityView.requestPart());
            stringBuilder.append(",");
        }
        String string = stringBuilder.toString();
        string = string.substring(0, string.length()-1);
        string = string + "where employee_id = " + employeeId + ';';
        return string;
    }
}
