package entity;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * Класс работа. Реализует интерфейс Predicate для фильтрации
 * полученного из базы данных списка сотрудников по параметру "Сведения о работе"
 */
public class Job implements Predicate<Job> {
    private final GettingStarted gettingStarted;
    private final TableNumber tableNumber;
    private final Division division;
    private final Post post;
    private final EmploymentAgreement agreement;
    private final WorkSchedule workSchedule;
    private final HolidaySchedule holidaySchedule;
    private final Payment payment;

    public Job(
            GettingStarted gettingStarted,
            TableNumber tableNumber,
            Division division,
            Post post,
            EmploymentAgreement agreement,
            WorkSchedule workSchedule,
            HolidaySchedule holidaySchedule,
            Payment payment) {
        this.gettingStarted = gettingStarted;
        this.tableNumber = tableNumber;
        this.division = division;
        this.post = post;
        this.agreement = agreement;
        this.workSchedule = workSchedule;
        this.holidaySchedule = holidaySchedule;
        this.payment = payment;
    }


    @Override
    public boolean test(Job job) {
        return (
                this.gettingStarted.test(job.gettingStarted)  &&
                this.tableNumber.test(job.tableNumber) &&
                this.division.test(job.division) &&
                this.post.test(job.post) &&
                this.agreement.test(job.agreement) &&
                this.workSchedule.test(job.workSchedule) &&
                this.holidaySchedule.test(job.holidaySchedule) &&
                this.payment.test(job.payment));
    }
}
