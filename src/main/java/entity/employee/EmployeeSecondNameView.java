package entity.employee;

import org.example.ui.TextEntityView;

public class EmployeeSecondNameView extends TextEntityView {
    public EmployeeSecondNameView(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "Фамилия";
    }

    @Override
    protected String ORMCellTitle() {
        return "second_name";
    }
}
