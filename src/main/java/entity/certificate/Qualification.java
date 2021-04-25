package entity.certificate;

import org.example.ui.RadioButtonEntityView;
import org.example.ui.TextEntityView;

public class Qualification extends TextEntityView {


    protected Qualification(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "Присвоена квалификация";
    }

    @Override
    public String column() {
        return "qualification";
    }
}
