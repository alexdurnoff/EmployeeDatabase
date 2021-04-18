package entity;

import java.time.LocalDate;

/**
 * Трудовой договор сотрудника с датой заключения.
 * Реализует интерфейс Predicate<EmploymentContract> для фильтрации списка.
 */
public class EmploymentContract implements EmploymentAgreement{
    private final LocalDate localDate;

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
}
