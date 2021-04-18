package entity;

import java.util.function.Predicate;

public interface EmploymentAgreement extends Predicate<EmploymentAgreement> {
    String title();
}
