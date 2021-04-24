package org.example.ui.filters;

import dao.DataBase;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Фильр по дате
 */
public abstract class DateFilter implements Filter {
    private final DataBase dataBase;
    private final Button applyButton;
    private final Button cancelButton;
    private final HBox hBox;
    private final DatePicker datePicker;
    private final List<Integer> employeeIdList = new ArrayList<>();

    protected DateFilter(DataBase dataBase) {
        this.dataBase = dataBase;
        this.applyButton = new Button("Применить");
        this.cancelButton = new Button("Отмена");
        this.hBox = new HBox();
        this.datePicker = new DatePicker();
    }

    /**
     * Имя таблицы базы данных
     * @return String table name.
     */
    protected abstract String tableName();

    /**
     * Название столбца в таблице
     * @return String column name.
     */
    protected abstract String columnName();

    @Override
    public List<Integer> employeeIdList() {
        return employeeIdList;
    }

    @Override
    public Button applyButton() {
        return this.applyButton;
    }

    @Override
    public Button cancelButton() {
        return this.cancelButton;
    }

    @Override
    public void clear() {
        this.employeeIdList.clear();
        this.datePicker.setValue(null);
    }

    @Override
    public HBox hbox() {
        return this.hBox;
    }

    @Override
    public void fillEmployeeIdList() throws SQLException {
        if (this.datePicker.getValue() != null) {
            String request = "select employee_id from " + tableName() +
                    " where " + columnName() + " = " +
                    "'" + this.datePicker.getValue().toString() + "';";
            ResultSet resultSet = dataBase.getResultSet(request);
            while (resultSet.next()){
                this.employeeIdList.add(resultSet.getInt(1));
            }
        }

    }
}
