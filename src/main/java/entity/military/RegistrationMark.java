package entity.military;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.layout.GridPane;
import org.example.ui.TextEntityView;

public class RegistrationMark extends TextEntityView {

    protected RegistrationMark(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "отметка о снятии с воинского учета";
    }

    @Override
    public String column() {
        return "military_registration_mark";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
