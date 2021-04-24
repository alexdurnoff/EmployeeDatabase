package org.example.ui.filters;

import javafx.scene.layout.VBox;
import org.example.ui.EmployeeListVbox;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Панель фильтрации.
 */
public class FilterPane extends VBox {

    private final List<Filter> filterList;
    private final EmployeeListVbox employeeListVbox;

    public FilterPane(List<Filter> filterList, EmployeeListVbox employeeListVbox) {
        this.employeeListVbox = employeeListVbox;
        this.filterList = filterList;
        filterList.forEach(filter -> {
            filter.applyButton().setOnAction(ae -> {
                try {
                    filter.fillEmployeeIdList();
                    applyFilter();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });
            filter.cancelButton().setOnAction(ae -> {
                filter.clear();
                try {
                    clearFilter();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });
            this.getChildren().add(filter.hbox());
        });
    }

    /**
     * Возврат списка идентификаторов сотрудников.
     * @return - List<Integer> employeeIDList.
     * @throws SQLException - бросает исключение, если что-то не так при работе с базой.
     */
    public List<Integer> employeeIdList() throws SQLException {
        List<Integer> employeeIdList = new ArrayList<>();
        for (Filter filter : filterList){
            employeeIdList.addAll(filter.employeeIdList());
        }
        return employeeIdList;
    }

    /**
     * Обновление панели списка сотрудников после применения фильтра.
     */
    void applyFilter() throws SQLException {
        this.employeeListVbox.filterView();
    }

    /**
     * Обновление панели списка сотрудников после очистки фильтра.
     */
    void clearFilter() throws SQLException {
        this.employeeListVbox.defaultView();
    }


}
