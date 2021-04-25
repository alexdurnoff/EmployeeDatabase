package entity.document;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DocumentType implements EntityView {
    private final ChoiceBox<String> choiceBox;

    public DocumentType(String string) {
        this.choiceBox = new ChoiceBox<>();
        this.choiceBox.getItems().add("паспорт");
        this.choiceBox.getItems().add("вид на жительство");
        this.choiceBox.setValue(string);
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("вид документа");
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
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
        return this.choiceBox.getValue();
    }

    @Override
    public String column() {
        return "document_type";
    }
}
