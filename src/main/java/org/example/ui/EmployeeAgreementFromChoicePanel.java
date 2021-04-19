package org.example.ui;

import entity.agreement.ContractAgreement;
import entity.agreement.DefaultAgreement;
import entity.agreement.EmploymentAgreement;
import entity.agreement.EmploymentContract;
import javafx.scene.control.DatePicker;

/**
 * Класс достает из панели выбора соответствующее трудовое соглашение.
 */
public class EmployeeAgreementFromChoicePanel {
    private final EmploymentAgreementChooser employmentAgreementChooser;
    private final DatePicker datePickerFrom;
    private final DatePicker datePickerTo;


    public EmployeeAgreementFromChoicePanel(EmploymentAgreementChooser employmentAgreementChooser,
                                            DatePicker datePickerFrom,
                                            DatePicker datePickerTo) {
        this.employmentAgreementChooser = employmentAgreementChooser;
        this.datePickerFrom = datePickerFrom;
        this.datePickerTo = datePickerTo;

    }

    public EmploymentAgreement agreement() {
        if (this.employmentAgreementChooser.valueProperty().getValue().equals("трудовой договор")){
            return new EmploymentContract(this.datePickerFrom.getValue());
        }
        if (this.employmentAgreementChooser.valueProperty().getValue().equals("трудовое соглашение")){
            return new ContractAgreement(
                    this.datePickerFrom.getValue(),
                    this.datePickerTo.getValue()
            );
        }
        return new DefaultAgreement();
    }
}
