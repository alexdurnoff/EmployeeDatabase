package entity.job;

import org.example.ui.TextEntityView;


public class HolidaySchedule extends TextEntityView {

    public HolidaySchedule(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "График отпусков";
    }

    @Override
    public String column() {
        return "holiday_schedule";
    }
}
