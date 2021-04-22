package org.example.ui.filters;

import dao.DataBase;
import entity.military.MilitaryRankEnumEntity;


public class MilitaryRankFilter extends EnumFilter{
    protected MilitaryRankFilter(DataBase dataBase, MilitaryRankEnumEntity enumEntity) {
        super(dataBase, enumEntity);
    }

    @Override
    protected String tableName() {
        return "military";
    }

    @Override
    public String labelName() {
        return "Фильтр по воинскому званию";
    }
}
