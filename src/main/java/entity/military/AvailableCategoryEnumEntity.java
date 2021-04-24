package entity.military;

import javafx.util.StringConverter;
import org.example.ui.EnumEntity;

public enum AvailableCategoryEnumEntity implements EnumEntity {
    G("Г"),
    GO("ГО"),
    VN("ВН"),
    NGM("НГМ"),
    NGI("НГИ"),
    GNS("ГНС"),
    IND("ИНД"),
    DEFAULTCATEGORY("категория готовности");

    private final String title;

    AvailableCategoryEnumEntity(String title){
        this.title = title;
    }

    @Override
    public String labelName() {
        return "категория готовности к воинской службе";
    }

    @Override
    public String columnName() {
        return "available_category";
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
        return DEFAULTCATEGORY;
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

    public static AvailableCategoryEnumEntity entityByTitle(String title){
        AvailableCategoryEnumEntity[] values = values();
        for (AvailableCategoryEnumEntity value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTCATEGORY;
    }
}
