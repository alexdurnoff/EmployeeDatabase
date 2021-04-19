package daoservice;

import entity.MilitaryRegistration;

public interface MilitaryRegistrationService {
    MilitaryRegistration findByEmployeeId(int employeeId);
}
