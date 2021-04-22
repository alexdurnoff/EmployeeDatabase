package entity.job;

import entity.EntityView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * Класс инкапсулирует DataPicker для взаимодействия с пользователем.
 * Возвращает значение выбранной пользователем даты принятия на работу.
 */
public class GettingStartedView implements Predicate<GettingStartedView>, EntityView {
    /**
     * Дата начала работы сотрудника
     */
    private final DatePicker datePicker;
    private final Label label;

    /**
     * Основной конструктор
     * @param localDate - дата начала работы.
     */
    public GettingStartedView(LocalDate localDate) {
        this.datePicker = new GettingStartedDatePicker(localDate);
        this.label = new Label(datePicker.getValue().toString());
    }

    public GettingStartedView(String date){
        GettingStartedDatePicker datePicker1;
        Label label1;
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date);
            datePicker1 = new GettingStartedDatePicker(localDate);
            label1 = new Label(datePicker1.getValue().toString());
        } catch (Exception e){
            datePicker1 = new GettingStartedDatePicker();
            label1 = new Label();
        }
        this.datePicker = datePicker1;
        this.label = label1;
    }

    /**
     * Конструктор без параметров. Присваивается значение по умолчанию.
     */
    public GettingStartedView(){
        this.datePicker = new DatePicker();
        this.label = new Label();
        this.datePicker.setOnAction(ae -> {
            this.label.setText(datePicker.getValue().toString());
        });
    }

    /**
     *
     * @param gettingStarted - GettingStarte, с которым сравнивается наша дата начала работы.
     * @return true, если даты начала совпадают, или если в качестве аргумента метода прилетело
     * GettingStarted со значением даты начала работы по умолчанию, т.е. 01 января 190ё0 года
     */
    @Override
    public boolean test(GettingStartedView gettingStarted) {
        return this.datePicker.getValue().equals(gettingStarted.datePicker.getValue());
    }


    @Override
    public String toString() {
        return this.datePicker.getValue().toString();
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber){
        Label header = new Label("Дата принятия на работу");
        gridPane.add(header,0, rowNumber);
        gridPane.add(this.label, 1, rowNumber);
        gridPane.add(this.datePicker, 2, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set getting_started = " +
                "'" +
                userChoice() +
                "'";
    }

    public String userChoice() {
        return this.datePicker.getValue().toString();//Пока так.
    }
}
