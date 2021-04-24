package entity.military;

import javafx.util.StringConverter;
import org.example.ui.EnumEntity;

public enum MilitaryRegistrationEnumEntity implements EnumEntity {
    GENERIC("общий"),
    SPECIAL("специальный"),
    DEFAULTREGISTRATION("воинский учет");

    private final String title;

    MilitaryRegistrationEnumEntity(String title){
        this.title = title;
    }

    @Override
    public String labelName() {
        return "воинский учет";
    }

    @Override
    public String columnName() {
        return "military_registration";
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
        return DEFAULTREGISTRATION;
    }

    @Override
    public StringConverter<EnumEntity> stringConverter() {
        return new StringConverter<EnumEntity>() {
            @Override
            public String toString(EnumEntity object) {
                return object.title();
            }

            @Override
            public EnumEntity fromString(String string) {
                return entityByTitle(string);
            }
        };
    }

    public static MilitaryRegistrationEnumEntity entityByTitle(String title){
        MilitaryRegistrationEnumEntity[] values = values();
        for (MilitaryRegistrationEnumEntity value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTREGISTRATION;
    }
}
