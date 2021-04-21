package entity.gettingstarted;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class GettingStartedDatePicker extends DatePicker {

    public GettingStartedDatePicker(){
        super();
    }

    public GettingStartedDatePicker(LocalDate localDate){
        super(localDate);
    }
}
