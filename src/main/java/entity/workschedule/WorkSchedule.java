package entity.workschedule;

import entity.EntityView;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.function.Predicate;

public class WorkSchedule implements Predicate<WorkSchedule>, EntityView {
    private final String content;
    private final WorkScheduleTextField textField;

    public WorkSchedule(String content) {
        this.content = content;
        this.textField = new WorkScheduleTextField();
    }

    @Override
    public boolean test(WorkSchedule workSchedule) {
        if (workSchedule.content.equals(content)) return true;
        return false;
    }

    public String userChoice(){
        return this.textField.getText();
    }

    public void addToGridPane(GridPane gridPane, int rowNumber){
        Label label = new Label("график работы");
        gridPane.add(label, 0, rowNumber);
        gridPane.add(textField, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set work_schedule = " +
                "'" +
                userChoice() +
                "'";
    }
}
