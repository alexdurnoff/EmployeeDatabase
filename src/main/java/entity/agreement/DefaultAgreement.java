package entity.agreement;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class DefaultAgreement implements EmploymentAgreement {
    @Override
    public boolean test(EmploymentAgreement employmentAgreement) {
        return true;
    }

    @Override
    public String title() {
        return "трудовое соглашение";
    }

    @Override
    public String from() {
        return "дата заключения";
    }

    @Override
    public String to() {
        return "дата окончания";
    }

    @Override
    public void setFrom(LocalDate localDate) {

    }

    @Override
    public void setTo(LocalDate localDate) {

    }

    @Override
    public LocalDate localDateFrom() {
        return LocalDate.now();
    }

    @Override
    public LocalDate localDateTo() {
        return LocalDate.now();
    }

    @Override
    public DatePicker datePickerFrom() {
        return new DatePicker();
    }
}
