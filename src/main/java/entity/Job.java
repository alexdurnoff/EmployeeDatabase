package entity;

import card.EmployeeInformationNode;
import dao.DataBase;
import entity.agreement.EmploymentAgreement;
import javafx.scene.Node;

import java.util.function.Predicate;

/**
 * Класс работа. Реализует интерфейс Predicate для фильтрации
 * полученного из базы данных списка сотрудников по параметру "Сведения о работе"
 */
public class Job implements Predicate<Job>, EmployeeInformationNode {
    private final int employeeId;
    private GettingStarted gettingStarted;
    private TableNumber tableNumber;
    private Division division;
    private Post post;
    private EmploymentAgreement agreement;
    private WorkSchedule workSchedule;
    private HolidaySchedule holidaySchedule;
    private Payment payment;

    public Job(
            int employeeId,
            GettingStarted gettingStarted,
            TableNumber tableNumber,
            Division division,
            Post post,
            EmploymentAgreement agreement,
            WorkSchedule workSchedule,
            HolidaySchedule holidaySchedule,
            Payment payment) {
        this.employeeId = employeeId;
        this.gettingStarted = gettingStarted;
        this.tableNumber = tableNumber;
        this.division = division;
        this.post = post;
        this.agreement = agreement;
        this.workSchedule = workSchedule;
        this.holidaySchedule = holidaySchedule;
        this.payment = payment;
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

    public Division getDivision() {
        return division;
    }

    public Post getPost() {
        return post;
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

    public Payment getPayment() {
        return payment;
    }

    @Override
    public boolean test(Job job) {
        return (
                this.gettingStarted.test(job.gettingStarted) &&
                        this.tableNumber.test(job.tableNumber) &&
                        this.division.test(job.division) &&
                        this.post.test(job.post) &&
                        this.agreement.test(job.agreement) &&
                        this.workSchedule.test(job.workSchedule) &&
                        this.holidaySchedule.test(job.holidaySchedule) &&
                        this.payment.test(job.payment));
    }

    @Override
    public Node node() {
        return null;
    }

    @Override
    public void update(DataBase dataBase) {

    }
}
