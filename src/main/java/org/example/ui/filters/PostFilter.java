package org.example.ui.filters;

import dao.DataBase;
import entity.job.PostEnumEntity;

/**
 * Фильр по должности
 */
public class PostFilter extends EnumFilter{
    protected PostFilter(DataBase dataBase, PostEnumEntity enumEntity) {
        super(dataBase, enumEntity);
    }

    @Override
    protected String tableName() {
        return "job";
    }


    @Override
    public String labelName() {
        return "Фильтр по должности";
    }
}
