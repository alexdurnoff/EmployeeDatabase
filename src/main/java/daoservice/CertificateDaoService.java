package daoservice;

import dao.DataBase;
import entity.Certificate;

public class CertificateDaoService implements CertificateService {
    public CertificateDaoService(DataBase dataBase) {
    }

    @Override
    public Certificate findByEmployeeId(int employeeId) {
        return null;
    }
}
