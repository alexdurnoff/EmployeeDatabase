package entity.military;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.layout.GridPane;
import org.example.ui.TextEntityView;

public class MilitaryCommissariat extends TextEntityView {

    protected MilitaryCommissariat(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "военный комиссариат";
    }

    @Override
    public String column() {
        return "military_commissariat";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
