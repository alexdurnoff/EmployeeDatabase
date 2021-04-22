package org.example.ui.filters;

import dao.DataBase;
import entity.military.AvailableCategoryEnumEntity;
import org.example.ui.EnumEntity;

public class MilitaryAvailableCategoryFilter extends EnumFilter{
    protected MilitaryAvailableCategoryFilter(DataBase dataBase, AvailableCategoryEnumEntity enumEntity) {
        super(dataBase, enumEntity);
    }

    @Override
    protected String tableName() {
        return "military";
    }

    @Override
    public String labelName() {
        return "Фильтр по готовности к воинской службе";
    }
}
