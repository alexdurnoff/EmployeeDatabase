package entity;

import java.time.LocalDate;

/**
 * Договор подряда сотрудника от даты до даты.
 */
public class ContractAgreement implements EmploymentAgreement{
    private final LocalDate localDateFrom;
    private final LocalDate localDateTO;

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
}
