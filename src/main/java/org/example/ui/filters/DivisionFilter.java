package org.example.ui.filters;

import dao.DataBase;
import entity.job.agreement.DivisionEnumEntity;


public class DivisionFilter extends EnumFilter{
    protected DivisionFilter(DataBase dataBase, DivisionEnumEntity enumEntity) {
        super(dataBase, enumEntity);
    }

    @Override
    protected String tableName() {
        return "job";
    }

    @Override
    protected String columnName() {
        return "division";
    }

    @Override
    public String labelName() {
        return "Фильтр по подразделению";
    }
}
