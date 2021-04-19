package daoservice;

import dao.DataBase;
import entity.Document;

public class DocumentDaoService implements DocumentService {
    public DocumentDaoService(DataBase dataBase) {
    }

    @Override
    public Document findByEmployeeId(int employeeId) {
        return null;
    }
}
