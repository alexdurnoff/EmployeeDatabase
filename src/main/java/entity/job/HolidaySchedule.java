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
    protected String ORMCellTitle() {
        return "holiday_schedule";
    }
}
