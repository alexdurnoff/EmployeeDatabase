package entity;

import java.util.function.Predicate;

public class WorkSchedule implements Predicate<WorkSchedule> {

    @Override
    public boolean test(WorkSchedule workSchedule) {
        return false;
    }
}
