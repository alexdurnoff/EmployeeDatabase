package daoservice;

import dao.DataBase;
import entity.Dossier;

public class DossierDaoService implements DossierService {
    public DossierDaoService(DataBase dataBase) {
    }

    @Override
    public Dossier findByEmployeeId(int employeeId) {
        return null;
    }
}
