package entity.military;

import org.example.ui.EnumEntity;

public enum MilitaryDivisionEnumEntity implements EnumEntity {
    MEDICAL("медицинский"),
    COMMAND("командный"),
    SOLDIER("солдаты"),
    SAILOR("матрос"),
    DEFAULTMILITARYDIVISION("воинский состав(профиль)");

    private final String title;

    MilitaryDivisionEnumEntity(String title){
        this.title = title;
    }

    @Override
    public String labelName() {
        return "воинский состав";
    }

    @Override
    public String columnName() {
        return "military_division";
    }

    @Override
    public String title() {
        return this.title;
    }

    @Override
    public EnumEntity defaultValue() {
        return DEFAULTMILITARYDIVISION;
    }
}
