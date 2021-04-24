package org.example.ui.filters;

import dao.DataBase;

public class DocumentTypeFilter extends TextFilter{
    protected DocumentTypeFilter(DataBase dataBase) {
        super(dataBase);
    }

    @Override
    protected String tableName() {
        return "documents";
    }

    @Override
    protected String columnName() {
        return "document_type";
    }


    @Override
    public String labelName() {
        return "Фильр по типу документа";
    }
}
