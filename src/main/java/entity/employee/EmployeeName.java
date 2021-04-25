package entity.employee;

import entity.EntityView;
import org.example.ui.TextEntityView;

public class EmployeeName extends TextEntityView {

    public EmployeeName(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "Имя";
    }

    @Override
    public String column() {
        return "name";
    }
}
