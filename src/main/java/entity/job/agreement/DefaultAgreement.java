package entity.job.agreement;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class DefaultAgreement implements EmploymentAgreement {
    private final ChoiceBox<EmploymentAgreement> choiceBox;

    public DefaultAgreement() {
        this.choiceBox = new AgreementChoiceBox();
    }


    @Override
    public boolean test(EmploymentAgreement employmentAgreement) {
        return true;
    }

    @Override
    public String title() {
        return "трудовое соглашение";
    }

    @Override
    public String from() {
        return "дата заключения";
    }

    @Override
    public String to() {
        return "дата окончания";
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = label();
        this.choiceBox.setValue(this);
        this.choiceBox.setConverter(stringConverter());
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
        choiceBox.setOnAction(ae -> {
            gridPane.getChildren().remove(label);
            gridPane.getChildren().remove(choiceBox);
            choiceBox.getValue().addToGridPane(gridPane,rowNumber);
        });

    }


    public EntityView userChoice() {
        return null;
    }

    @Override
    public String requestPart() {
        return null;
    }

    @Override
    public String insertRequestValue() {
        return "трудовое соглашение, " +
                LocalDate.now() + ", " + LocalDate.now();
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
