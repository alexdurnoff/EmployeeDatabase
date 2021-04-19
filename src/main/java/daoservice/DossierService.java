package daoservice;

import entity.Dossier;

public interface DossierService {
    Dossier findByEmployeeId(int employeeId);
}
