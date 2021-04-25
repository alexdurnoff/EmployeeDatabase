package entity.document;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.ui.NumberFormatExceptionWindow;

public class DocumentNumber implements EntityView {
    private int number;
    private final TextField textField;

    public DocumentNumber(String string) {
        this.number = Integer.parseInt(string);
        this.textField = new TextField(string);
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("номер документа");
        this.textField.textProperty().addListener(((observable, oldValue, newValue) -> {
            try {
                number = Integer.parseInt(newValue);
            } catch (NumberFormatException exception){
                NumberFormatExceptionWindow.show();
            }
        }));
        gridPane.add(label, 0, rowNumber);
        gridPane.add(textField, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "document_number = " + number;
    }

    @Override
    public String insertRequestValue() {
        return String.valueOf(number);
    }

    @Override
    public String column() {
        return "document_number";
    }
}
