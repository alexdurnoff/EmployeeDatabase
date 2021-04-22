package entity.military;

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
    public EnumEntity defaultValue() {
        return DEFAULTRANK;
    }
}
