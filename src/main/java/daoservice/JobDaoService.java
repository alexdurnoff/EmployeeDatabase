package daoservice;

import dao.DataBase;
import entity.Job;

import java.util.HashMap;
import java.util.Map;

public class JobDaoService implements JobService {
    private final DataBase dataBase;
    private final Map<Integer, Job> jobMap;
    public JobDaoService(DataBase dataBase) {
        this.dataBase = dataBase;
        this.jobMap = new HashMap<>();
        updateMap();
    }

    private void updateMap() {

    }

    @Override
    public Job findByEmployeeId(int employeeId) {

        return null;
    }

    @Override
    public void update() {

    }
}
