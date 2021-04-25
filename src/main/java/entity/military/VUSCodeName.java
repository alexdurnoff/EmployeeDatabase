package entity.military;

import entity.EntityView;
import javafx.scene.layout.GridPane;
import org.example.ui.TextEntityView;

public class VUSCodeName extends TextEntityView {

    protected VUSCodeName(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "полное кодовое обозначение ВУС";
    }

    @Override
    public String column() {
        return "vus_code_name";
    }
}
