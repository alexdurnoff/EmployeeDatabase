package entity.document;

import entity.EntityView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class BirthDate implements EntityView {
    private LocalDate localDate;
    private final DatePicker datePicker;

    public BirthDate(String string) {
        this.localDate = LocalDate.parse(string);
        this.datePicker = new DatePicker(localDate);
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("дата рождения");
        this.datePicker.setOnAction(ae -> this.localDate = this.datePicker.getValue());
        gridPane.add(label, 0, rowNumber);
        gridPane.add(datePicker, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set birth_date = " +
                "'" +
                this.datePicker.getValue().toString() +
                "'";
    }
}
