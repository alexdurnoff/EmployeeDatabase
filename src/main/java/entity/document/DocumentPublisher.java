package entity.document;

import org.example.ui.TextEntityView;

public class DocumentPublisher extends TextEntityView {

    protected DocumentPublisher(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "орган, выдавший документ";
    }

    @Override
    public String column() {
        return "document_publisher";
    }
}
