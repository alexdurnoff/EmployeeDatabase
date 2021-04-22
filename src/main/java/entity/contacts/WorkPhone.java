package entity.contacts;

import org.example.ui.TextEntityView;

public class WorkPhone extends TextEntityView {

    protected WorkPhone(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "рабочий номер телефона";
    }

    @Override
    protected String ORMCellTitle() {
        return "work_number";
    }
}
