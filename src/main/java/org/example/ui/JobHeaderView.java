package org.example.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Заголовок сведений о работе в карточке сотрудника.
 */
public class JobHeaderView {
    private final Label label = new Label("Сведения о работе");

    public void addToGridPane(GridPane gridPane, int rowNumber){
        gridPane.add(label, 0, rowNumber);
        rowNumber++;
    }
}
