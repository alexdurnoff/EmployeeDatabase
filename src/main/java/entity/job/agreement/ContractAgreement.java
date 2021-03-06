package entity.job.agreement;

import hibernate.HibernateEntity;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

/**
 * Договор подряда сотрудника от даты до даты.
 */
public class ContractAgreement implements EmploymentAgreement {
    private LocalDate localDateFrom;
    private LocalDate localDateTO;
    private final ChoiceBox<EmploymentAgreement> choiceBox;

    public ContractAgreement(LocalDate localDateFrom, LocalDate localDateTO) {
        this.localDateFrom = localDateFrom;
        this.localDateTO = localDateTO;
        this.choiceBox = new AgreementChoiceBox();
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
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = label();
        DatePickerFrom datePickerFrom = new DatePickerFrom(this.localDateFrom);
        datePickerFrom.setOnAction(ae -> this.localDateFrom = datePickerFrom.getValue());
        DatePickerTo datePickerTo = new DatePickerTo(this.localDateTO);
        datePickerTo.setOnAction(ae -> this.localDateTO = datePickerTo.getValue());
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
        gridPane.add(datePickerFrom, 2, rowNumber);
        gridPane.add(datePickerTo, 3, rowNumber);
        /*choiceBox.setOnAction(ae -> {
            gridPane.getChildren().remove(label);
            gridPane.getChildren().remove(choiceBox);
            gridPane.getChildren().remove(datePickerFrom);
            gridPane.getChildren().remove(datePickerTo);
            choiceBox.getValue().addToGridPane(gridPane,rowNumber);
        });*/

    }

    @Override
    public String requestPart() {
        return "agreement = 'договор подряда', date_from = '" +
                localDateFrom + "', date_to = '" + localDateTO + "'";
    }

    @Override
    public String insertRequestValue() {
        return this.choiceBox.getValue().title() +
                ", " + localDateFrom.toString() +
                ", " + localDateTO.toString();
    }

    @Override
    public String column() {
        return "agreement, date_from, date_to";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
