package org.example.ui.filters;

import dao.DataBase;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Фильтр с текстовым полем ввода. Пользователь вводит
 * текст, по которому фильтруется список сотрудников.
 */
public abstract class TextFilter implements Filter {
    private final DataBase dataBase;
    private final Button applyButton;
    private final Button cancelButton;
    private final HBox hBox;
    private final TextField textField;
    private final List<Integer> employeeIdList = new ArrayList<>();

    protected TextFilter(DataBase dataBase) {
        this.dataBase = dataBase;
        this.applyButton = new Button("Применить");
        this.cancelButton = new Button("Отмена");
        this.hBox = new HBox();
        this.textField = new TextField();
        this.hBox.getChildren().add(new Label(labelName()));
        this.hBox.getChildren().add(textField);
        this.hBox.getChildren().add(applyButton);
        this.hBox.getChildren().add(cancelButton);
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
        this.textField.setText(null);
    }

    @Override
    public HBox hbox() {
        return this.hBox;
    }

    @Override
    public void fillEmployeeIdList() throws SQLException {
        if (this.textField.getText() != null) {
            String request = "select employee_id from " + tableName() +
                    " where " + columnName() + " = " + "'" + this.textField.getText() + "';";
            ResultSet resultSet = dataBase.getResultSet(request);
            while (resultSet.next()){
                this.employeeIdList.add(resultSet.getInt(1));
            }
        }
    }
}
