package entity.contacts;

import hibernate.HibernateEntity;
import org.example.ui.TextEntityView;

public class WorkPhone extends TextEntityView {

    protected WorkPhone(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "рабочий номер телефона";
    }

    @Override
    public String column() {
        return "work_number";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
