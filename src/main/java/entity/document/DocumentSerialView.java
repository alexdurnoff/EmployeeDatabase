package entity.document;

import org.example.ui.TextEntityView;

public class DocumentSerialView extends TextEntityView {

    protected DocumentSerialView(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "серия";
    }

    @Override
    protected String ORMCellTitle() {
        return "document_serial";
    }
}
