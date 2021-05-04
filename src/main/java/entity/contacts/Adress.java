package entity.contacts;


import hibernate.HibernateEntity;
import org.example.ui.TextEntityView;

public class Adress extends TextEntityView {

    protected Adress(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "домашний адрес";
    }

    @Override
    public String column() {
        return "home_adress";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }

}
