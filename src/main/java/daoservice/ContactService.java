package daoservice;

import entity.Contacts;

public interface ContactService {
    Contacts findByEmployeeId(int employeeId);
}
