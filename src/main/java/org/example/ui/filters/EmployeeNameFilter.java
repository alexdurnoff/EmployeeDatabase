package org.example.ui.filters;

import dao.DataBase;

public class EmployeeNameFilter extends TextFilter{
    protected EmployeeNameFilter(DataBase dataBase) {
        super(dataBase);
    }

    @Override
    public String labelName() {
        return "Фильтр по имени";
    }

    @Override
    protected String tableName() {
        return "documents";
    }

    @Override
    protected String columnName() {
        return "name";
    }

}
