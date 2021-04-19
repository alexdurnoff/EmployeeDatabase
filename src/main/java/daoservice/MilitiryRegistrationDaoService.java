package daoservice;

import dao.DataBase;
import entity.MilitaryRegistration;

public class MilitiryRegistrationDaoService implements MilitaryRegistrationService {
    public MilitiryRegistrationDaoService(DataBase dataBase) {
    }

    @Override
    public MilitaryRegistration findByEmployeeId(int employeeId) {
        return null;
    }
}
