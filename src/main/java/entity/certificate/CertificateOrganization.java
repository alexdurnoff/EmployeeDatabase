package entity.certificate;

import entity.EntityView;
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
    protected String ORMCellTitle() {
        return "certificate_organization";
    }
}
