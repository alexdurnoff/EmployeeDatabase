package org.example.ui;

import entity.agreement.EmploymentAgreement;
import entity.Filter;
import entity.EmployeeEntity;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAgreementChoicePanel extends HBox implements Filter {
    private final List<EmployeeEntity> employeeEntityList;
    private final EmploymentAgreementChooser employmentAgreementChooser;
    private final DatePicker datePickerFrom;
    private final DatePicker datePickerTo;



    public EmployeeAgreementChoicePanel(List<EmployeeEntity> employeeEntityList) {
        this.employeeEntityList = employeeEntityList;
        this.datePickerFrom = new DatePicker();
        this.datePickerTo = new DatePicker();
        this.employmentAgreementChooser = new EmploymentAgreementChooser();
        this.employmentAgreementChooser.setOnAction(ae -> {
            if (employmentAgreementChooser.valueProperty().getValue().equals("трудовой договор")){
                this.getChildren().clear();
                this.getChildren().add(employmentAgreementChooser);
                this.getChildren().add(datePickerFrom);
            } else if (employmentAgreementChooser.valueProperty().getValue().equals("договор подряда")){
                this.getChildren().clear();
                this.getChildren().add(employmentAgreementChooser);
                this.getChildren().add(datePickerFrom);
                this.getChildren().add(datePickerTo);
            } else if (employmentAgreementChooser.valueProperty().getValue().equals("трудовое соглашение")){
                this.getChildren().clear();
                this.getChildren().add(employmentAgreementChooser);
            }
        });
    }

    @Override
    public List<EmployeeEntity> filter() {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        EmploymentAgreement employmentAgreement = new EmployeeAgreementFromChoicePanel(
                this.employmentAgreementChooser,
                this.datePickerFrom,
                this.datePickerTo
        ).agreement();
        return null;
    }
}
