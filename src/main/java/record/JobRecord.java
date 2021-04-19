package record;

import dao.DataBase;
import entity.*;
import entity.agreement.*;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import org.example.ui.GettingStartedView;
import org.example.ui.JobHeaderView;
import org.example.ui.TableNumberView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JobRecord implements Record {
    private final DataBase dataBase;
    private final int employeeId;
    private GettingStartedView gettingStartedView;
    private TableNumberView tableNumberView;
    private Division division;
    private Post post;
    private EmploymentAgreement agreement;
    private WorkSchedule workSchedule;
    private HolidaySchedule holidaySchedule;
    private Payment payment;

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
            this.division = Division.divisionByName(resultSet.getString(3));
            this.post = Post.postByName(resultSet.getString(4));
            this.agreement = new AgreementFromResultSet(resultSet).employmentAgreement();
            this.workSchedule = new WorkSchedule(resultSet.getString(8));
            this.holidaySchedule = new HolidaySchedule(resultSet.getString(9));
            this.payment = Payment.paymentByTitle(resultSet.getString(10));
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
                .append(gettingStartedView.toString())
                .append("'")
                .append(',')
                .append("set table_number = ")
                .append(tableNumberView.value())
                .append(", ")
                .append("set division = ")
                .append("'")
                .append(division.toString())
                .append("'")
                .append(", ")
                .append(" set post = ")
                .append("'")
                .append(post.toString())
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
                .append(" set work_schedule = ")
                .append("'")
                .append(workSchedule.toString())
                .append("'")
                .append(", ")
                .append(" set holyday_schedule = ")
                .append("'")
                .append(holidaySchedule.toString())
                .append("'")
                .append(", ")
                .append(" set payment = ")
                .append("'")
                .append(payment.toString())
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
        new JobHeaderView().addToGridPane(gridPane,rowNumber);
        rowNumber++;
        this.gettingStartedView.addToGridPane(gridPane,rowNumber);
        rowNumber++;

        return gridPane;
    }

    @Override
    public boolean filter(Record record) {
        if (record.getClass() != JobRecord.class) return true;
        JobRecord jobRecord = (JobRecord) record;

        return (
                this.gettingStartedView.test(jobRecord.gettingStartedView) &&
                        this.tableNumberView.test(jobRecord.tableNumberView) &&
                        this.division.test(jobRecord.division) &&
                        this.post.test(jobRecord.post) &&
                        this.agreement.test(jobRecord.agreement) &&
                        this.workSchedule.test(jobRecord.workSchedule) &&
                        this.holidaySchedule.test(jobRecord.holidaySchedule) &&
                        this.payment.test(jobRecord.payment));
    }
}
