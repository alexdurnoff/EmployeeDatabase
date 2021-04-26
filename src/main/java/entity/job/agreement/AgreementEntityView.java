package entity.job.agreement;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.example.ui.EnumEntity;

public class AgreementEntityView implements EntityView {
    private final AgreementEnumEntity entity;
    private final ChoiceBox<String> choiceBox;
    private final DatePickerTo datePickerTo;
    private final DatePickerFrom datePickerFrom;

    public AgreementEntityView(AgreementEnumEntity entity) {
        this.entity = entity;
        this.choiceBox = new ChoiceBox<>();
        this.datePickerFrom = entity.datePickerFrom();
        this.datePickerTo = entity.datePickerTo();
    }


    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label(entity.labelName());
        EnumEntity[] enumEntities = entity.valueArray();
        for (EnumEntity entity1 : enumEntities){
            this.choiceBox.getItems().add(entity1.title());
        }
        this.choiceBox.setValue(entity.title());
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
        gridPane.add(datePickerFrom, 2, rowNumber);
        gridPane.add(datePickerTo, 3, rowNumber);
    }

    @Override
    public String requestPart() {
        return "agreement = '" + choiceBox.getValue() +
                "', date_from = '" + datePickerFrom.dateFrom() +
                "', date_to = '" + datePickerTo.dateTo() + "'";
    }

    @Override
    public String insertRequestValue() {
        return choiceBox.getValue()
                + ", " + datePickerFrom.dateFrom()
                + ", " + datePickerTo.dateTo();
    }

    @Override
    public String column() {
        return "agreement, date_from, date_to";
    }
}
