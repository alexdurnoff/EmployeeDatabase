package daoservice;

import entity.Certificate;

public interface CertificateService {
    Certificate findByEmployeeId(int employeeId);
}
