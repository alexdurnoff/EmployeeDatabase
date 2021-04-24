package org.example.ui.filters;

import dao.DataBase;
import entity.job.PaymentEnumEntity;
import entity.job.PostEnumEntity;
import entity.job.DivisionEnumEntity;
import entity.military.MilitaryDivisionEnumEntity;
import entity.military.MilitaryRankEnumEntity;

import java.util.ArrayList;
import java.util.List;

public class FilterList {
    private final List<Filter> filters = new ArrayList<>();

    public FilterList(DataBase dataBase) {
        this.filters.add(new EmployeeNameFilter(dataBase));
        this.filters.add(new EmployeeSecondNameFilter(dataBase));
        this.filters.add(new BirthDateFilter(dataBase));
        this.filters.add(new DocumentTypeFilter(dataBase));
        this.filters.add(new DivisionFilter(dataBase, DivisionEnumEntity.DEFAULTDIVISION));
        this.filters.add(new PostFilter(dataBase, PostEnumEntity.DEFAULTPOST));
        this.filters.add(new PaymentFilter(dataBase, PaymentEnumEntity.DEFAULTPAYMANET));
        this.filters.add(new MilitaryDivisionFilter(dataBase, MilitaryDivisionEnumEntity.DEFAULTMILITARYDIVISION));
        this.filters.add(new MilitaryRankFilter(dataBase, MilitaryRankEnumEntity.DEFAULTRANK));
    }


    public List<Filter> filterList() {
        return filters;
    }
}
