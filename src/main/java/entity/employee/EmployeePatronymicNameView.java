package entity.employee;

import org.example.ui.TextEntityView;

public class EmployeePatronymicNameView extends TextEntityView {
    public EmployeePatronymicNameView(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "Отчество";
    }

    @Override
    protected String ORMCellTitle() {
        return "patronymic_name";
    }
}
