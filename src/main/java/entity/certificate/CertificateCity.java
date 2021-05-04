package entity.certificate;

import hibernate.HibernateEntity;
import org.example.ui.TextEntityView;

public class CertificateCity extends TextEntityView {

    protected CertificateCity(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "город прохождения";
    }

    @Override
    public String column() {
        return "certificate_city";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
