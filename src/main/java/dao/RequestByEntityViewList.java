package dao;

import entity.EntityView;

import java.sql.SQLException;
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
                .append(table)
                .append(" set");
        for (EntityView entityView : entityViewList) {
            stringBuilder.append(' ');
            stringBuilder.append(entityView.requestPart());
            stringBuilder.append(",");
        }
        String string = stringBuilder.toString();
        string = string.substring(0, string.length()-1);//Убрали последнюю запятую
        string = string + " where employee_id = " + employeeId + ';';
        return string;
    }

    /**
     * Метод создания запроса для добавления нового сотрудника
     * @return String request
     */
    public String insertRequest() throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ")
                .append(table)
                .append(new EntityRequestColumns(entityViewList).columns())
                .append(new EntityRequestValues(employeeId, entityViewList).values())
                .append(';');
        return stringBuilder.toString();
    }
}
