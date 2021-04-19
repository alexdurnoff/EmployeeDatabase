package entity.agreement;

import java.time.LocalDate;

/**
 * Договор подряда сотрудника от даты до даты.
 */
public class ContractAgreement implements EmploymentAgreement {
    private LocalDate localDateFrom;
    private LocalDate localDateTO;

    public ContractAgreement(LocalDate localDateFrom, LocalDate localDateTO) {
        this.localDateFrom = localDateFrom;
        this.localDateTO = localDateTO;
    }

    @Override
    public boolean test(EmploymentAgreement employmentAgreement) {
        if (employmentAgreement.getClass() != ContractAgreement.class) return false;
        ContractAgreement contractAgreement = (ContractAgreement) employmentAgreement;
        return (
                this.localDateFrom.equals(contractAgreement.localDateFrom) &&
                        this.localDateTO.equals(contractAgreement.localDateTO)
        );
    }


    @Override
    public String title() {
        return "договор подряда";
    }

    @Override
    public String from() {
        return localDateFrom.toString();
    }

    @Override
    public String to() {
        return localDateTO.toString();
    }

    @Override
    public void setFrom(LocalDate localDate) {
        this.localDateFrom = localDate;
    }

    @Override
    public void setTo(LocalDate localDate) {
        this.localDateTO = localDate;
    }

    @Override
    public LocalDate localDateFrom() {
        return this.localDateFrom;
    }

    @Override
    public LocalDate localDateTo() {
        return this.localDateTO;
    }
}
