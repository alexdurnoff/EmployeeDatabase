package entity.dossier;

import dao.DataBase;
import org.example.ui.TextEntityView;

public class DossierEntityView extends TextEntityView {

    protected DossierEntityView(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return null;
    }

    @Override
    protected String ORMCellTitle() {
        return null;
    }
}
