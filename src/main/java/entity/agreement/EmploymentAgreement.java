package entity.agreement;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface EmploymentAgreement extends Predicate<EmploymentAgreement>, EntityView {
    String title();
    String from();
    String to();

    default StringConverter<EmploymentAgreement> stringConverter(){
        return new StringConverter<EmploymentAgreement>() {
            @Override
            public String toString(EmploymentAgreement object) {
                return object.title();
            }

            @Override
            public EmploymentAgreement fromString(String string) {
                if (string.equals("трудовой договор")){
                    return new EmploymentContract(LocalDate.now());
                } else if (string.equals("договор подряда")) {
                    return new ContractAgreement(LocalDate.now(), LocalDate.now());
                }
                return new DefaultAgreement();
            }
        };
    }

    default Label label(){
        return new Label("трудовое соглашение");
    }

}
