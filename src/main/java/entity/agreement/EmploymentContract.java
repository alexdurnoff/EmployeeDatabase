package entity.agreement;

import java.time.LocalDate;

/**
 * Трудовой договор сотрудника с датой заключения.
 * Реализует интерфейс Predicate<EmploymentContract> для фильтрации списка.
 */
public class EmploymentContract implements EmploymentAgreement {
    private LocalDate localDate;

    public EmploymentContract(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public boolean test(EmploymentAgreement employmentAgreement) {
        if (employmentAgreement.getClass() != EmploymentContract.class) return false;
        EmploymentContract employmentContract = (EmploymentContract) employmentAgreement;
        return employmentContract.localDate.equals(this.localDate);
    }

    @Override
    public String title() {
        return "трудовой договор";
    }

    @Override
    public String from() {
        return localDate.toString();
    }

    @Override
    public String to() {
        return "";
    }

    @Override
    public void setFrom(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public void setTo(LocalDate localDate) {

    }

    @Override
    public LocalDate localDateFrom() {
        return this.localDate;
    }

    @Override
    public LocalDate localDateTo() {
        return this.localDate;
    }
}
