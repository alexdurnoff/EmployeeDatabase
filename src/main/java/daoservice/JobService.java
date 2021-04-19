package daoservice;

import entity.Job;

public interface JobService {
    Job findByEmployeeId(int employeeId);
}
