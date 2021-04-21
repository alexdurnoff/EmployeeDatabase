package entity.holydayschedule;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import java.util.function.Predicate;

public class HolidaySchedule implements Predicate<HolidaySchedule>, EntityView {
    private final String content;
    private final TextField textField;

    public HolidaySchedule(String content) {
        this.content = content;
        this.textField = new HolydayScheduleTextField();
    }

    @Override
    public boolean test(HolidaySchedule holidaySchedule) {
        if (holidaySchedule.content.equals(content)) return true;
        return false;
    }

    public void addToGridPane(GridPane gridPane, int rowNumber){
        Label label = new Label("График отпусков");
        gridPane.add(label, 0, 1);
        gridPane.add(textField, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set holyday_schedule = " +
                "'" +
                userChoice() + "'";
    }

    public String userChoice(){
        return this.textField.getText();
    }
}
