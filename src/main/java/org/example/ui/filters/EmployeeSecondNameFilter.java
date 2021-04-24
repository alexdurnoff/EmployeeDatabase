package org.example.ui.filters;

import dao.DataBase;

public class EmployeeSecondNameFilter extends TextFilter{
    protected EmployeeSecondNameFilter(DataBase dataBase) {
        super(dataBase);
    }

    @Override
    public String labelName() {
        return "Фильтр по фамилии";
    }

    @Override
    protected String tableName() {
        return "documents";
    }

    @Override
    protected String columnName() {
        return "second_name";
    }
}
