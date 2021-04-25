package entity.military;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс инкапсулирует воинское звание.
 * Реализует интерфейс Predicate<MilitaryRankView> для фильтрации списка.
 * Возвращает выбранное пользователем значение.
 */
public enum MilitaryRankView implements EntityView, Predicate<MilitaryRankView> {
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
    private final ChoiceBox<MilitaryRankView> choiceBox;

    MilitaryRankView(String string) {
        this.title = string;
        this.choiceBox = new ChoiceBox<>();
    }

    public static MilitaryRankView rankByTitle(String title){
        MilitaryRankView[] militaryRankViews = values();
        for (MilitaryRankView militaryRankView : militaryRankViews) {
            if (militaryRankView.title.equals(title)) return militaryRankView;
        }
        return DEFAULTRANK;
    }

    @Override
    public void addToGridPane(GridPane gridPane, int rowNumber) {
        Label label = new Label("Воинское звание");
        this.choiceBox.getItems().addAll(Arrays.asList(values()));
        this.choiceBox.setConverter(new StringConverter<MilitaryRankView>() {
            @Override
            public String toString(MilitaryRankView object) {
                return object.title;
            }

            @Override
            public MilitaryRankView fromString(String string) {
                return rankByTitle(string);
            }
        });
        this.choiceBox.setValue(this);
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox,1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set military_rank = " +
                "'" +
                this.userChoice().title +
                "'";
    }

    @Override
    public String insertRequestValue() {
        return this.userChoice().title;
    }

    @Override
    public String column() {
        return "military_rank";
    }

    /**
     * Выбранное пользователем значение.
     * @return - MilitaryRank, выбранное в ChoiceBox.
     */
    private MilitaryRankView userChoice(){
        return this.choiceBox.getValue();
    }

    /**
     *
     * @param militaryRankView - MilitaryRank, с которым сравнивается наше звание.
     * @return true, если звание совпадает с нашим, или если прилетело DEFAULTRANK.
     */
    @Override
    public boolean test(MilitaryRankView militaryRankView) {
        if (militaryRankView == DEFAULTRANK) return true;
        return this == militaryRankView;
    }
}
