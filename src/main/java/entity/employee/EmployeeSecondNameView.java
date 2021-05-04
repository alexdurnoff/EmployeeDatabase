package entity.employee;

import hibernate.HibernateEntity;
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
    public String column() {
        return "second_name";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
