package entity.employee;

import entity.EntityView;
import hibernate.HibernateEntity;
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

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
