package org.example.ui;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public abstract class RadioButtonEntityView implements EntityView {
    private final RadioButton radioButtonYes;
    private final RadioButton radioButtonNo;
    private final TextField textField;
    private final ToggleGroup toggleGroup;

    public RadioButtonEntityView(String yesOrNo, String content) {
        this.textField = new TextField();
        if (yesOrNo.equals("да")) textField.setText(content);
        this.radioButtonYes = new RadioButton("Да");
        radioButtonYes.setOnAction(ae -> {
            if (radioButtonYes.isSelected()) {
                textField.setEditable(true);
            }
        });
        this.radioButtonNo = new RadioButton("Нет");
        radioButtonNo.setOnAction(ae -> {
            if (radioButtonNo.isSelected()) {
                textField.setText("");
                textField.setEditable(false);
            }
        });
        this.toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().add(radioButtonYes);
        toggleGroup.getToggles().add(radioButtonNo);
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label(labelHeader());
        gridPane.add(label, 0, rowNumber);
        gridPane.add(radioButtonYes, 1, rowNumber);
        gridPane.add(radioButtonNo, 2, rowNumber);
    }

    private String yesOrNo(){
        if (toggleGroup.getSelectedToggle().equals(radioButtonYes)) return "Да";
        return "Нет";
    }

    /**
     * Заголовок Label во вьюшке.
     * @return - String label header.
     */
    protected abstract String labelHeader();


    /**
     * Заголовок певрого столбца таблицы в базе данных.
     * Там, где хранится "да" или "нет".
     * @return - String column1 header.
     */
    protected abstract String column1Header();

    /**
     * Загловок второго столбца таблицы, там где хранится
     * контент в случае "да" и пустая строка в случае "нет".
     * @return - String column2 header.
     */
    protected abstract String column2Header();

    @Override
    public String requestPart() {
        return "set " + column1Header() + " = " + yesOrNo() + ',' +
                "set " + column2Header() + " = " + "'" + textField.getText() + "'";
    }
}
