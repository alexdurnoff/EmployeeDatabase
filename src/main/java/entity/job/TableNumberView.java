package entity.job;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.ui.NumberFormatExceptionWindow;

/**
 * Вьюшка для взаимодействия с пользователем.
 * Получает от пользователя новое значение
 * табельного номера. Возвращает это значение
 * для записи в базу.
 */
public class TableNumberView implements EntityView {
    private final TextField textField;
    private final Label label;

    /**
     * Значение по умолчанию. Если пользователь в текстовом поле фильтра не указывает
     * табельный номер сотрудника, то присваивается это значение.
     * В этом случае считаем, что наш метод тест будет возвращать true,
     * если прилетит TableNumber с таким номером.
     */
    private final static int defaultTableNumber = -100;


    private final static int incorrectValue = -200;

    public TableNumberView(int tableNumber){
        this.textField = new TableNumberTextField(String.valueOf(tableNumber));
        this.label = new Label("табельный номер");
        this.textField.textProperty().addListener(((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(textField.getText());
            } catch (NumberFormatException numberFormatException){
                NumberFormatExceptionWindow.show();
            }
        }));
    }

    public TableNumberView(){
        this(defaultTableNumber);
    }

    public int value(){
        return Integer.parseInt(textField.getText());
    }

    public void addToGridPane(GridPane gridPane, int rowNumber){
        gridPane.add(label, 0, rowNumber);
        gridPane.add(textField, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "table_number = " + this.value();
    }

    @Override
    public String insertRequestValue() {
        return String.valueOf(this.value());
    }

    @Override
    public String column() {
        return "table_number";
    }

    public boolean test(TableNumberView tableNumberView) {
        if (tableNumberView.value() == defaultTableNumber) return true;
        return this.value() == tableNumberView.value();
    }

    public int userChoice(){
        return Integer.parseInt(this.textField.getText());
    }

}
