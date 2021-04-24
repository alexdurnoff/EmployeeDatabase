package entity.military;

import javafx.util.StringConverter;
import org.example.ui.EnumEntity;

public enum MilitaryDivisionEnumEntity implements EnumEntity {
    MEDICAL("медицинский"),
    COMMAND("командный"),
    SOLDIER("солдаты"),
    SAILOR("матрос"),
    DEFAULTMILITARYDIVISION("воинский состав(профиль)");

    private final String title;

    MilitaryDivisionEnumEntity(String title){
        System.out.println("MilitaryDivision string in constructor is " + title);
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
    public EnumEntity[] valueArray() {
        return values();
    }

    @Override
    public EnumEntity defaultValue() {
        return DEFAULTMILITARYDIVISION;
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

    public static MilitaryDivisionEnumEntity entityByTitle(String title){
        MilitaryDivisionEnumEntity[] values = values();
        for (MilitaryDivisionEnumEntity value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTMILITARYDIVISION;
    }

}
