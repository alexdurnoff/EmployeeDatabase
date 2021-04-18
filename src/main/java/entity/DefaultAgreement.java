package entity;

public class DefaultAgreement implements EmploymentAgreement{
    @Override
    public boolean test(EmploymentAgreement employmentAgreement) {
        return true;
    }

    @Override
    public String title() {
        return "трудовое соглашение";
    }
}
