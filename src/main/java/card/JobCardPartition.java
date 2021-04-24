package card;

import dao.DataBase;
import entity.EntityView;
import entity.job.JobEntityViewList;

import java.sql.SQLException;
import java.util.List;

/**
 * Раздел информации в катрочке сотрудника о его работе.
 */
public class JobCardPartition extends EmployeeCardPartition{
    private final List<EntityView> entityViewList;

    public JobCardPartition(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
        this.entityViewList = new JobEntityViewList(this.dataBase,this.employeeId).jobEntityViewList();
    }

    @Override
    protected String table() {
        return "jobs";
    }

    @Override
    protected List<EntityView> entityViewList() throws SQLException {
        return this.entityViewList;
    }
}
