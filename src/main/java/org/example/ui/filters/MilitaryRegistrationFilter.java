package org.example.ui.filters;

import dao.DataBase;
import entity.military.MilitaryRegistrationEnumEntity;

public class MilitaryRegistrationFilter extends EnumFilter{
    protected MilitaryRegistrationFilter(DataBase dataBase, MilitaryRegistrationEnumEntity enumEntity) {
        super(dataBase, enumEntity);
    }

    @Override
    protected String tableName() {
        return "military";
    }

    @Override
    public String labelName() {
        return "Фильтр по воинскому учету";
    }
}
