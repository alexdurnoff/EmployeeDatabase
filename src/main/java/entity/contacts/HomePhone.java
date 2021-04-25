package entity.contacts;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.ui.TextEntityView;

public class HomePhone extends TextEntityView {

    protected HomePhone(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "домашний номер телефона";
    }

    @Override
    public String column() {
        return "home_number";
    }
}
