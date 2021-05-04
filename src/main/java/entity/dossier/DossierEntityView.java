package entity.dossier;

import dao.DataBase;
import hibernate.HibernateEntity;
import org.example.ui.TextEntityView;

public class DossierEntityView extends TextEntityView {

    protected DossierEntityView(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "Досье";
    }

    @Override
    public String column() {
        return "dossier";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
