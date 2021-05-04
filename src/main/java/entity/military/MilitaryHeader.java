package entity.military;

import hibernate.HibernateEntity;
import org.example.ui.HeaderEntityView;

public class MilitaryHeader extends HeaderEntityView {

    @Override
    protected String labelTitle() {
        return "сведения о воинском учете";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
