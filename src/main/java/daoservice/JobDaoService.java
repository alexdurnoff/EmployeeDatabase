package daoservice;

import dao.DataBase;
import entity.Job;

public class JobDaoService implements JobService {
    public JobDaoService(DataBase dataBase) {
    }

    @Override
    public Job findByEmployeeId(int employeeId) {
        return null;
    }
}
