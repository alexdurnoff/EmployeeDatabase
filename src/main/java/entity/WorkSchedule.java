package entity;

import java.util.function.Predicate;

public class WorkSchedule implements Predicate<WorkSchedule> {
    private final String content;

    public WorkSchedule(String content) {
        this.content = content;
    }

    @Override
    public boolean test(WorkSchedule workSchedule) {
        if (workSchedule.content.equals(content)) return true;
        return false;
    }
}
