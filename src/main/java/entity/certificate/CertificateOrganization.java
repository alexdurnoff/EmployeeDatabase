package entity.certificate;

import entity.EntityView;
import hibernate.HibernateEntity;
import org.example.ui.TextEntityView;

public class CertificateOrganization extends TextEntityView {

    protected CertificateOrganization(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "организация";
    }

    @Override
    public String column() {
        return "certificate_organization";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
