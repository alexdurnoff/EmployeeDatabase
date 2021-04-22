package org.example.ui.filters;

import dao.DataBase;
import entity.job.PaymentEnumEntity;
import org.example.ui.EnumEntity;

public class PaymentFilter extends EnumFilter{
    protected PaymentFilter(DataBase dataBase, PaymentEnumEntity enumEntity) {
        super(dataBase, enumEntity);
    }

    @Override
    protected String tableName() {
        return "job";
    }

    @Override
    public String labelName() {
        return "Фильтр по оплате";
    }
}
