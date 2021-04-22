package org.example.ui;

import javafx.scene.control.Dialog;

public class SaveDialog extends Dialog<Boolean> {

    public SaveDialog(){
        this.setHeaderText("Изменения не сохранены");
        this.setContentText("Сохранить изменения?");
    }
}
