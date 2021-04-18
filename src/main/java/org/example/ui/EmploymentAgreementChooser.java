package org.example.ui;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

/**
 * Класс для выбора типа трудового договора. Выбирает тип договора
 * и добавляет необходимое количество DateChooser в родительский Hbox;
 */
public class EmploymentAgreementChooser extends ChoiceBox<String> {

    public EmploymentAgreementChooser(){
        this.getItems().add("трудовой договр");
        this.getItems().add("договор подряда");
        this.getItems().add("трудовое соглашение");
    }


}
