package daoservice;

import entity.Document;

public interface DocumentService {
    Document findByEmployeeId(int employeeId);
}
