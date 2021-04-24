package entity.contacts;


import org.example.ui.TextEntityView;

public class Adress extends TextEntityView {

    protected Adress(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "домашний адрес";
    }

    @Override
    protected String ORMCellTitle() {
        return "home_adress";
    }

}
