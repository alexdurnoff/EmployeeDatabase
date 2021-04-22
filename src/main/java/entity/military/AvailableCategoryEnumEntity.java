package entity.military;

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
    public EnumEntity defaultValue() {
        return DEFAULTCATEGORY;
    }
}
