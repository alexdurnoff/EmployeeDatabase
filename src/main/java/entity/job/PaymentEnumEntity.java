package entity.job;

import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;
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
    public EnumEntity[] valueArray() {
        return values();
    }

    @Override
    public EnumEntity defaultValue() {
        return DEFAULTPAYMANET;
    }

    @Override
    public StringConverter<EnumEntity> stringConverter() {
        return new StringConverter<EnumEntity>() {
            @Override
            public String toString(EnumEntity object) {
                System.out.println("invoking toString and return " + object.title());
                return object.title();
            }

            @Override
            public EnumEntity fromString(String string) {
                System.out.println("invoking fromString and return " + entityByTitle(title));
                return entityByTitle(string);
            }
        };
    }

    public static PaymentEnumEntity entityByTitle(String title){
        PaymentEnumEntity[] values = values();
        for (PaymentEnumEntity value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTPAYMANET;
    }
}
