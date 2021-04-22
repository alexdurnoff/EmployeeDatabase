package entity.military;

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
    public EnumEntity defaultValue() {
        return DEFAULTREGISTRATION;
    }
}
