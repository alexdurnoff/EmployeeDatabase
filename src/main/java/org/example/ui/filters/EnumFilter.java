package org.example.ui.filters;

import dao.DataBase;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;
import org.example.ui.EnumEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Фильтр по перечислению.
 */
public abstract class EnumFilter implements Filter{
    private final DataBase dataBase;
    private final Button applyButton;
    private final Button cancelButton;
    private final EnumEntity enumEntity;
    private final HBox hBox;
    private final ChoiceBox<EnumEntity> choiceBox;
    private final List<Integer> employeeIdList = new ArrayList<>();

    protected EnumFilter(DataBase dataBase, EnumEntity enumEntity){
        this.dataBase = dataBase;
        this.enumEntity = enumEntity;
        this.applyButton = new Button("Применить");
        this.cancelButton = new Button("Отмена");
        this.hBox = new HBox();
        this.choiceBox = new ChoiceBox<>();
        this.choiceBox.getItems().addAll(Arrays.asList(enumEntity.valueArray()));
        this.choiceBox.setValue(enumEntity.defaultValue());
        this.choiceBox.setConverter(enumEntity.stringConverter());
        this.hBox.getChildren().add(new Label(labelName()));
        this.hBox.getChildren().add(choiceBox);
        this.hBox.getChildren().add(applyButton);
        this.hBox.getChildren().add(cancelButton);
        this.hBox.setSpacing(10);
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
    protected String columnName(){
        return this.enumEntity.columnName();
    };



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
        this.choiceBox.setValue(enumEntity.defaultValue());
    }

    @Override
    public HBox hbox() {
        return this.hBox;
    }

    @Override
    public void fillEmployeeIdList() throws SQLException {
        if (this.choiceBox.getValue() != enumEntity.defaultValue()) {
            String request = "select employee_id from " + tableName() +
                    " where " + columnName() + " = " + "'"
                    + this.choiceBox.getValue().title() + "';";
            ResultSet resultSet = dataBase.getResultSet(request);
            while (resultSet.next()){
                this.employeeIdList.add(resultSet.getInt(1));
            }
        }

    }
}
