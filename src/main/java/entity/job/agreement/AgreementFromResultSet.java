package entity.job.agreement;

import java.sql.ResultSet;
import java.time.LocalDate;

/**
 * Класс инкапсулирует ResultSet и возвращает
 * EmployeeAgreement
 */
public class AgreementFromResultSet {
    private final ResultSet resultSet;

    public AgreementFromResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public EmploymentAgreement employmentAgreement(){
        LocalDate fromDate;
        LocalDate toDate;
        String type;
        try {
            type = resultSet.getString(6);
            System.out.println("agreement type is " + type);
            fromDate = LocalDate.parse(resultSet.getString(6));
            toDate = LocalDate.parse(resultSet.getString(7));
        } catch (Exception exception){
            return new DefaultAgreement();
        }
        if (type.equals("трудовой контракт") || type.equals("трудовой договор")) {
            return new EmploymentContract(fromDate);
        } else if (type.equals("трудовое соглашение")){
            return new ContractAgreement(fromDate, toDate);
        }
        return new DefaultAgreement();
    }
}
