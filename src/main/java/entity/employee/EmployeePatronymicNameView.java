package entity.employee;

import hibernate.HibernateEntity;
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
    public String column() {
        return "patronymic_name";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
