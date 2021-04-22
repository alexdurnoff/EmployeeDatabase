package entity.job;

import org.example.ui.EnumEntity;

public enum PaymentEnumEntity implements EnumEntity {
    NULLPERCENT("0%"),
    FORTYPERCENT("40%"),
    FIFTYPERCENT("50%"),
    EIGHTYPERCENT("80%"),
    HUNDREDPERCENT("100%"),
    DEFAULTPAYMANET("Оплата")
    ;

    private final String title;

    PaymentEnumEntity(String title){
        this.title = title;
    }

    @Override
    public String labelName() {
        return "оплата";
    }

    @Override
    public String columnName() {
        return "payment";
    }

    @Override
    public String title() {
        return this.title;
    }

    @Override
    public EnumEntity defaultValue() {
        return DEFAULTPAYMANET;
    }
}
