package entity.military;

import javafx.util.StringConverter;
import org.example.ui.EnumEntity;

public enum MilitaryRankEnumEntity implements EnumEntity {
    DEFAULTRANK("воинское звание"),
    CONSCRIPT("подлежит призыву"),
    PRIVATESOLDIER("рядовой"),
    CORPORAL("ефрейтор"),
    JUNIORSERGANT("младший сержант"),
    SERGANT("сержант"),
    SENOIRSERGANT("старший сержант"),
    PETTYOFFICER("старшина"),
    ENSIGN("прапорщик"),
    SECONDLIEUTENANT("младший лейтенант"),
    LIEUTENANT("лейтенант"),
    SENOIRLIEUTENANT("старший лейтенант"),
    CAPTAIN("капитан"),
    MAJOR("майор"),
    LIEUTENANTCOLONEL("подполковник"),
    COLONEL("полковник"),
    MAJORGHENERAL("генерал-майор"),
    LIEUTENANTGENERAL("генерал-лейтенант"),
    COLONELGENERAL("генерал-полковник")
    ;

    private final String title;

    MilitaryRankEnumEntity(String title){
        this.title = title;
    }

    @Override
    public String labelName() {
        return "Воинское звание";
    }

    @Override
    public String columnName() {
        return "military_rank";
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
        return DEFAULTRANK;
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

    public static MilitaryRankEnumEntity entityByTitle(String title){
        MilitaryRankEnumEntity[] values = values();
        for (MilitaryRankEnumEntity value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTRANK;
    }




}
