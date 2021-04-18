package entity;

import java.util.function.Predicate;

/**
 * Класс инкапсулирует подразделение сотрудника.
 * Реализует интерфейс Predicate<Division> для фильтрации списка.
 */
public enum Division implements Predicate<Division> {
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

    Division(String title) {
        this.title = title;
    }


    /**
     *
     * @param division - Division, с которым сравнивается наше подразделение.
     * @return true, если подразделение совпадает с нашим, или если прилетело
     * DEFAULTDIVISION.
     */
    @Override
    public boolean test(Division division) {
        if (division == DEFAULTDIVISION) return true;
        return this == division;
    }


    @Override
    public String toString() {
        return this.title;
    }
}
