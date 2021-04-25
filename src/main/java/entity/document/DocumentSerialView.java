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
    public String column() {
        return "document_serial";
    }
}
