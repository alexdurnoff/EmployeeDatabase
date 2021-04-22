package entity.job.agreement;

import org.example.ui.EnumEntity;

public enum DivisionEnumEntity implements EnumEntity {
    ADMINISTRATION("администрация"),
    SUPPLEMENT("сектор снабжения"),
    TRANSPORT("транспортный участок"),
    MARKETING("бюро производства и маркетинга"),
    WORKSHOP3("цех №3"),
    WORKSHOP9("цех №9"),
    WORKSHOP8("цех №8"),
    BSC("БСЦ"),
    UKANDRP("УКиРП"),
    STAFFDEPARTMENT("кадровая служба"),
    ECONOMICDEPARTMENT("планово-экономический отдел"),
    CHIEFMECHANICSERVICE("служба главного механика"),
    CONSTRUCTIONDEPARTMENT("технологическо-конструкторское бюро"),
    REPAIRBUILDDEPARTMENT("ремонтно-строительный участок"),
    CHIEFENGENIERSERVICE("служба главного инженера"),
    CHIEFENERGETICSERVICE("служба главного энергетика"),
    LABORATORY("лаборатория"),
    OTK("ОТК"),
    OPIMDEPARTMENT("отдел ОПИМ"),
    ACCOUNTING("бухгалтерия"),
    DEFAULTDIVISION("Подразделение")
    ;

    private final String title;

    DivisionEnumEntity(String title){
        this.title = title;
    }

    @Override
    public String labelName() {
        return "Фильтр по подразделению";
    }

    @Override
    public String columnName() {
        return "division";
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public EnumEntity defaultValue() {
        return DEFAULTDIVISION;
    }
}
