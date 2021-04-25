package org.example.ui;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Вьюшка отображает текстовую запись в таблице.
 * Принимает введенное пользователем значение.
 * Возвращает в виде строки часть SQL-запроса.
 */
public abstract class TextEntityView implements EntityView {
    private final String textContent;
    private final TextField textField;


    protected TextEntityView(String textContent){
        this.textContent = textContent;
        this.textField = new TextField(textContent);
    }

    protected abstract String labelText();

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label(labelText());
        gridPane.add(label, 0, rowNumber);
        gridPane.add(textField, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return  column() +
                " = '" +
                value() +
                "'";
    }

    private String value(){
        if (this.textField.getText() == null) return "";
        return this.textField.getText();
    }

    @Override
    public String insertRequestValue() {
        return this.value();
    }

}
