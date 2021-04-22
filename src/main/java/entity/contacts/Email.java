package entity.contacts;

import org.example.ui.TextEntityView;

public class Email extends TextEntityView {

    protected Email(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "электронная почта";
    }

    @Override
    protected String ORMCellTitle() {
        return "email";
    }
}
