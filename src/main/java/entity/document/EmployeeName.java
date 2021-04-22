package entity.document;

import entity.EntityView;
import org.example.ui.TextEntityView;

public class EmployeeName extends TextEntityView {

    protected EmployeeName(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "Ф.И.О";
    }

    @Override
    protected String ORMCellTitle() {
        return "employee_name";
    }
}
