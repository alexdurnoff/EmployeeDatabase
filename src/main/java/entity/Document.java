package entity;

import java.time.LocalDate;
import java.util.function.Predicate;

public class Document implements Predicate<Document> {
    private final String number;
    private final String serial;
    private final LocalDate receiptDate;
    private final String organization;

    public Document(String number, String serial, LocalDate receiptDate, String organization) {
        this.number = number;
        this.serial = serial;
        this.receiptDate = receiptDate;
        this.organization = organization;
    }

    @Override
    public boolean test(Document document) {
        return false;
    }
}
