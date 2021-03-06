package entity.document;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class DocumentReleaseDate implements EntityView {
    private final LocalDate localDate;
    private final DatePicker datePicker;

    public DocumentReleaseDate(LocalDate localDate) {
        this.localDate = localDate;
        this.datePicker = new DatePicker(this.localDate);
    }

    public DocumentReleaseDate(String string){
        this.localDate = LocalDate.parse(string);
        this.datePicker = new DatePicker(this.localDate);
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("Дата выдачи документа");
        gridPane.add(label, 0, rowNumber);
        gridPane.add(datePicker, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return  column() + " = " +
                "'" +
                insertRequestValue() +
                "'";
    }

    @Override
    public String insertRequestValue() {
        return this.datePicker.getValue().toString();
    }

    @Override
    public String column() {
        return "document_release_date";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
