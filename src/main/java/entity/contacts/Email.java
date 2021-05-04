package entity.contacts;

import hibernate.HibernateEntity;
import org.example.ui.TextEntityView;

public class Email extends TextEntityView {

    protected Email(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "электронная почта";
    }

    @Override
    public String column() {
        return "email";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
