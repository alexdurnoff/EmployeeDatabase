package entity.job;

import dao.DataBase;
import entity.EntityView;
import entity.job.agreement.AgreementEntityView;
import entity.job.agreement.AgreementEnumEntity;
import entity.job.agreement.AgreementFromResultSet;
import entity.job.agreement.EmploymentAgreement;
import org.example.ui.EnumEntityView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс возвращает список сущностей для создания раздела Job в карточке.
 */
public class JobEntityViewList {
    private final List<EntityView> jobEntityViewList = new ArrayList<>();
    private final DataBase dataBase;
    private final int employeeId;

    public JobEntityViewList(DataBase dataBase, int employeeId) throws SQLException {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
    }


    public List<EntityView> jobEntityViewList() throws SQLException {
        this.jobEntityViewList.clear();
        String request = "select * from jobs where employee_id = " + employeeId;
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            //this.jobEntityViewList.add(new JobHeaderView());
            this.jobEntityViewList.add(new GettingStartedView(resultSet.getString(2)));
            this.jobEntityViewList.add(new TableNumberView(resultSet.getInt(3)));
            this.jobEntityViewList.add(new EnumEntityView(DivisionEnumEntity.entityByTitle(resultSet.getString(4))));
            this.jobEntityViewList.add(new EnumEntityView(PostEnumEntity.entityByTitle(resultSet.getString(5))));
            this.jobEntityViewList.add(new AgreementEntityView(AgreementEnumEntity.entityFromResultSet(resultSet)));
            this.jobEntityViewList.add(new WorkSchedule(resultSet.getString(9)));
            this.jobEntityViewList.add(new HolidaySchedule(resultSet.getString(10)));
            this.jobEntityViewList.add(new EnumEntityView(PaymentEnumEntity.entityByTitle(resultSet.getString(11))));
        }
        return this.jobEntityViewList;
    }

    /**
     * Список для добавления нового сотрудника
     * @return List<EntityView>
     */
    public List<EntityView> defaultList() {
        this.jobEntityViewList.clear();
        //this.jobEntityViewList.add(new JobHeaderView());
        this.jobEntityViewList.add(new GettingStartedView(""));
        this.jobEntityViewList.add(new TableNumberView(0));
        this.jobEntityViewList.add(new EnumEntityView(DivisionEnumEntity.entityByTitle("")));
        this.jobEntityViewList.add(new EnumEntityView(PostEnumEntity.entityByTitle("")));
        //this.jobEntityViewList.add(new AgreementFromResultSet(resultSet).employmentAgreement());
        this.jobEntityViewList.add(new WorkSchedule(""));
        this.jobEntityViewList.add(new HolidaySchedule(""));
        this.jobEntityViewList.add(new EnumEntityView(PaymentEnumEntity.entityByTitle("")));
        return this.jobEntityViewList;
    }
}
