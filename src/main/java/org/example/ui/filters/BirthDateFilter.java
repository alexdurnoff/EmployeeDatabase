package org.example.ui.filters;

import dao.DataBase;

public class BirthDateFilter extends DateFilter{
    protected BirthDateFilter(DataBase dataBase) {
        super(dataBase);
    }

    @Override
    protected String tableName() {
        return "documents";
    }

    @Override
    protected String columnName() {
        return "birth_date";
    }

    @Override
    public String labelName() {
        return "Фильтр по дате рождения";
    }
}
