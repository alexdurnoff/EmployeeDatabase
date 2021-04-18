package entity;

import java.util.function.Predicate;

public class HolidaySchedule implements Predicate<HolidaySchedule> {

    @Override
    public boolean test(HolidaySchedule holidaySchedule) {
        return false;
    }
}
