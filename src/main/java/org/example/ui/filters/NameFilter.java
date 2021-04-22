package org.example.ui.filters;

import dao.DataBase;

/**
 * Фильтр по ФИО сотрудника.
 */
public class NameFilter extends TextFilter{

    protected NameFilter(DataBase dataBase) {
        super(dataBase);
    }

    @Override
    protected String tableName() {
        return "documents";
    }

    @Override
    protected String columnName() {
        return "employee_name";
    }

    @Override
    public String labelName() {
        return "Фильтр по имени";
    }
}
