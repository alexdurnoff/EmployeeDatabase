package entity.job.agreement;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

/**
 * Трудовой договор сотрудника с датой заключения.
 * Реализует интерфейс Predicate<EmploymentContract> для фильтрации списка.
 */
public class EmploymentContract implements EmploymentAgreement {
    protected LocalDate localDateFrom;
    protected final ChoiceBox<EmploymentAgreement> choiceBox;

    public EmploymentContract(LocalDate localDateFrom) {
        this.localDateFrom = localDateFrom;
        this.choiceBox = new AgreementChoiceBox();
    }

    @Override
    public boolean test(EmploymentAgreement employmentAgreement) {
        if (employmentAgreement.getClass() != EmploymentContract.class) return false;
        EmploymentContract employmentContract = (EmploymentContract) employmentAgreement;
        return employmentContract.localDateFrom.equals(this.localDateFrom);
    }

    @Override
    public String title() {
        return "трудовой договор";
    }

    @Override
    public String from() {
        return localDateFrom.toString();
    }

    @Override
    public String to() {
        return "";
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = label();
        DatePicker datePicker = new DatePickerFrom(this.localDateFrom);
        datePicker.setOnAction(ae -> this.localDateFrom = datePicker.getValue());
        this.choiceBox.setValue(this);
        this.choiceBox.setConverter(stringConverter());
        /*this.choiceBox.setOnAction(ae ->{
            gridPane.getChildren().remove(label);
            gridPane.getChildren().remove(this.choiceBox);
            gridPane.getChildren().remove(datePicker);
            this.choiceBox.getValue().addToGridPane(gridPane, rowNumber);
        });*/
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
        gridPane.add(datePicker, 2, rowNumber);
    }


    @Override
    public String requestPart() {
        return "agreement = 'трудовой контракт', date_from = '" +
                this.localDateFrom + "'";
    }
}
