package entity;

import card.CardPartition;
import entity.agreement.EmploymentAgreement;
import entity.division.DivisionView;
import entity.holydayschedule.HolidaySchedule;
import entity.payment.PaymentView;
import entity.post.PostView;
import entity.tableNumber.TableNumber;
import entity.workschedule.WorkSchedule;
import javafx.scene.Node;

import java.util.function.Predicate;

/**
 * Класс работа. Реализует интерфейс Predicate для фильтрации
 * полученного из базы данных списка сотрудников по параметру "Сведения о работе"
 */
public class Job implements Predicate<Job>, CardPartition {
    private final int employeeId;
    private GettingStarted gettingStarted;
    private TableNumber tableNumber;
    private DivisionView divisionView;
    private PostView postView;
    private EmploymentAgreement agreement;
    private WorkSchedule workSchedule;
    private HolidaySchedule holidaySchedule;
    private PaymentView paymentView;

    public Job(
            int employeeId,
            GettingStarted gettingStarted,
            TableNumber tableNumber,
            DivisionView divisionView,
            PostView postView,
            EmploymentAgreement agreement,
            WorkSchedule workSchedule,
            HolidaySchedule holidaySchedule,
            PaymentView paymentView) {
        this.employeeId = employeeId;
        this.gettingStarted = gettingStarted;
        this.tableNumber = tableNumber;
        this.divisionView = divisionView;
        this.postView = postView;
        this.agreement = agreement;
        this.workSchedule = workSchedule;
        this.holidaySchedule = holidaySchedule;
        this.paymentView = paymentView;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public GettingStarted getGettingStarted() {
        return gettingStarted;
    }

    public TableNumber getTableNumber() {
        return tableNumber;
    }

    public DivisionView getDivision() {
        return divisionView;
    }

    public PostView getPost() {
        return postView;
    }

    public EmploymentAgreement getAgreement() {
        return agreement;
    }

    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public HolidaySchedule getHolidaySchedule() {
        return holidaySchedule;
    }

    public PaymentView getPayment() {
        return paymentView;
    }

    @Override
    public boolean test(Job job) {
        return (
                this.gettingStarted.test(job.gettingStarted) &&
                        this.tableNumber.test(job.tableNumber) &&
                        this.divisionView.test(job.divisionView) &&
                        this.postView.test(job.postView) &&
                        this.agreement.test(job.agreement) &&
                        this.workSchedule.test(job.workSchedule) &&
                        this.holidaySchedule.test(job.holidaySchedule) &&
                        this.paymentView.test(job.paymentView));
    }

    @Override
    public Node node() {
        return null;
    }

    @Override
    public void update() {

    }
}
