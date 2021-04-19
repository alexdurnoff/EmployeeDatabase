package entity;

import java.util.function.Predicate;

public class HolidaySchedule implements Predicate<HolidaySchedule> {
    private final String content;

    public HolidaySchedule(String content) {
        this.content = content;
    }

    @Override
    public boolean test(HolidaySchedule holidaySchedule) {
        if (holidaySchedule.content.equals(content)) return true;
        return false;
    }
}
