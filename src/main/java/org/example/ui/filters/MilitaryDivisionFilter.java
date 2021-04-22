package org.example.ui.filters;

import dao.DataBase;
import entity.military.MilitaryDivisionEnumEntity;


public class MilitaryDivisionFilter extends EnumFilter{
    protected MilitaryDivisionFilter(DataBase dataBase, MilitaryDivisionEnumEntity enumEntity) {
        super(dataBase, enumEntity);
    }

    @Override
    protected String tableName() {
        return "military";
    }

    @Override
    public String labelName() {
        return "Фильтр по воинскому составу";
    }
}
