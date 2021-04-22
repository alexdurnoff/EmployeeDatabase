package entity.military;

import entity.EntityView;
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
    protected String ORMCellTitle() {
        return "military_registration_mark";
    }
}
