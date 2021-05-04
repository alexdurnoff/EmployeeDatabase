package entity.job.agreement;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.control.Label;
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
                if (string.equals("трудовой договор") || string.equals("трудовой контракт")){
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

    @Override
    default HibernateEntity entity() {
        return null;
    }
}
