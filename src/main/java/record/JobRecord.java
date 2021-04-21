package record;

import dao.DataBase;
import entity.agreement.*;
import entity.division.DivisionView;
import entity.holydayschedule.HolidaySchedule;
import entity.payment.PaymentView;
import entity.post.PostView;
import entity.workschedule.WorkSchedule;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import entity.gettingstarted.GettingStartedView;
import entity.job.JobHeaderView;
import entity.tableNumber.TableNumberView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobRecord implements Record {
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

    public JobRecord(DataBase dataBase, int employeeId) throws SQLException {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
        updateParameters();
    }

    /**
     * Метод кэширует параметры, чтобы не лазить за ними в базу данных.
     * @throws SQLException
     */
    private void updateParameters() throws SQLException {
        String request = "select * from jobs";
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

    @Override
    public void update() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("update jobs")
                .append("\n")
                .append("set getting_started = ")
                .append("'")
                .append(gettingStartedView.userChoice())
                .append("'")
                .append(',')
                .append("set table_number = ")
                .append(tableNumberView.value())
                .append(", ")
                .append("set division = ")
                .append("'")
                .append(divisionView.usersChoice().toString())
                .append("'")
                .append(", ")
                .append("set post = ")
                .append("'")
                .append(postView.userChoice().toString())
                .append("'")
                .append(", ")
                .append(" set agreement = ")
                .append("'")
                .append(agreement.title())
                .append("'")
                .append(", ")
                .append(" set date_from = ")
                .append("'")
                .append(agreement.from())
                .append("'")
                .append(", ")
                .append(" set date_to = ")
                .append("'")
                .append(agreement.to())
                .append("'")
                .append(", ")
                .append("set work_schedule = ")
                .append("'")
                .append(workSchedule.userChoice())
                .append("'")
                .append(", ")
                .append("set holyday_schedule = ")
                .append("'")
                .append(holidaySchedule.userChoice())
                .append("'")
                .append(", ")
                .append("set payment = ")
                .append("'")
                .append(paymentView.userChoice())
                .append("'")
                .append(' ')
                .append("where employee_id = ")
                .append(employeeId)
                .append(";");
        this.dataBase.executeUpdateRequest(stringBuilder.toString());
    }

    @Override
    public Node node() {
        GridPane gridPane = new GridPane();
        int rowNumber = 0;
        new JobHeaderView().addToGridPane(gridPane, rowNumber++);
        this.gettingStartedView.addToGridPane(gridPane, rowNumber++);
        this.tableNumberView.addToGridPane(gridPane, rowNumber++);
        this.divisionView.addToGridPane(gridPane, rowNumber++);
        this.postView.addToGridPane(gridPane, rowNumber++);
        this.agreement.addToGridPane(gridPane, rowNumber++);
        this.holidaySchedule.addToGridPane(gridPane, rowNumber++);
        this.workSchedule.addToGridPane(gridPane, rowNumber++);
        this.paymentView.addToGridPane(gridPane, rowNumber++);
        return gridPane;
    }

    @Override
    public boolean filter(Record record) {
        if (record.getClass() != JobRecord.class) return true;
        JobRecord jobRecord = (JobRecord) record;

        return (
                this.gettingStartedView.test(jobRecord.gettingStartedView) &&
                        this.tableNumberView.test(jobRecord.tableNumberView) &&
                        this.divisionView.test(jobRecord.divisionView) &&
                        this.postView.test(jobRecord.postView) &&
                        this.agreement.test(jobRecord.agreement) &&
                        this.workSchedule.test(jobRecord.workSchedule) &&
                        this.holidaySchedule.test(jobRecord.holidaySchedule) &&
                        this.paymentView.test(jobRecord.paymentView));
    }
}
