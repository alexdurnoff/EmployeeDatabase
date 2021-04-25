package entity.military;

import entity.EntityView;
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
}
