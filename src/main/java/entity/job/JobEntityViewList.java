package entity.job;

import dao.DataBase;
import entity.EntityView;
import entity.agreement.AgreementFromResultSet;
import entity.agreement.EmploymentAgreement;
import entity.division.DivisionView;
import entity.gettingstarted.GettingStartedView;
import entity.holydayschedule.HolidaySchedule;
import entity.payment.PaymentView;
import entity.post.PostView;
import entity.tableNumber.TableNumberView;
import entity.workschedule.WorkSchedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс возвращает список сущностей для создания раздела Job в карточке.
 */
public class JobEntityViewList {
    private final List<EntityView> jobEntityViewList = new ArrayList<>();
    private final DataBase dataBase;
    private final int employeeId;
    private GettingStartedView gettingStartedView;
    private TableNumberView tableNumberView;
    private DivisionView divisionView;
    private PostView postView;
    private EmploymentAgreement agreement;
    private WorkSchedule workSchedule;
    private HolidaySchedule holidaySchedule;
    private PaymentView paymentView;

    public JobEntityViewList(DataBase dataBase, int employeeId) throws SQLException {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
        updateParameters();

    }

    /**
     * Метод кэширует параметры, чтобы не лазить за ними в базу данных.
     * @throws SQLException
     */
    private void updateParameters() throws SQLException {
        String request = "select * from jobs where employee_id = " + employeeId;
        ResultSet resultSet = dataBase.getResultSet(request);
        while (resultSet.next()){
            this.gettingStartedView =  new GettingStartedView(resultSet.getString(1));
            this.tableNumberView = new TableNumberView(resultSet.getInt(2));
            this.divisionView = DivisionView.divisionByName(resultSet.getString(3));
            this.postView = PostView.postByName(resultSet.getString(4));
            this.agreement = new AgreementFromResultSet(resultSet).employmentAgreement();
            this.workSchedule = new WorkSchedule(resultSet.getString(8));
            this.holidaySchedule = new HolidaySchedule(resultSet.getString(9));
            this.paymentView = PaymentView.paymentByTitle(resultSet.getString(10));
        }
    }

    public List<EntityView> jobEntityViewList(){
        this.jobEntityViewList.add(new JobHeaderView());
        this.jobEntityViewList.add(this.gettingStartedView);
        this.jobEntityViewList.add(this.tableNumberView);
        this.jobEntityViewList.add(this.divisionView);
        this.jobEntityViewList.add(this.postView);
        this.jobEntityViewList.add(this.agreement);
        this.jobEntityViewList.add(this.workSchedule);
        this.jobEntityViewList.add(this.holidaySchedule);
        this.jobEntityViewList.add(this.paymentView);
        return this.jobEntityViewList;
    }
}
