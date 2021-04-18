package entity;

import java.util.function.Predicate;

public enum Payment implements Predicate<Payment> {
    ;

    @Override
    public boolean test(Payment payment) {
        return false;
    }
}
