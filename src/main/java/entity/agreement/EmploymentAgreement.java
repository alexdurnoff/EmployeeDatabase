package entity.agreement;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface EmploymentAgreement extends Predicate<EmploymentAgreement> {
    String title();
    String from();
    String to();
    void setFrom(LocalDate localDate);
    void setTo(LocalDate localDate);
    LocalDate localDateFrom();
    LocalDate localDateTo();
    default ChoiceBox<String> choiceBox(){
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(
                "трудовой договор",
                "трудовое соглашение",
                "договор подряда"
        );
        choiceBox.setValue(title());
        return choiceBox;
    }

    default Label labelFrom(){
        return new Label(from());
    }

    default Label labelTo(){
        return new Label(to());
    }

    default DatePicker datePickerFrom(){
        DatePicker datePicker = new DatePicker(localDateFrom());
        return datePicker;
    }

    default DatePicker datePickerTo(){
        DatePicker datePicker = new DatePicker(localDateTo());
        return datePicker;
    }

}
