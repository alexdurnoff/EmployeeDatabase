package org.example.ui;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Заголовок раздела сведений в карточке сотрудника.
 */
public abstract class HeaderEntityView implements EntityView {

    protected abstract String labelTitle();

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        gridPane.add(new Label(labelTitle()), 0, rowNumber);
    }

    @Override
    public String requestPart() {
        return "";
    }

    @Override
    public String insertRequestValue() {
        return null;
    }

    @Override
    public String column() {
        return null;
    }
}
