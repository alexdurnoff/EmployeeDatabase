package daoservice;

import dao.DataBase;
import entity.Contacts;

public class ContactDaoService implements ContactService {
    public ContactDaoService(DataBase dataBase) {
    }

    @Override
    public Contacts findByEmployeeId(int employeeId) {
        return null;
    }
}
