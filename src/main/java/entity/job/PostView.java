package entity.job;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.util.function.Predicate;

/**
 * Класс инкакпсулирует должность сотрудника.
 * Реализует интерфейс Predicate<Post> для фильтрации списка.
 */
public enum PostView implements Predicate<PostView>, EntityView {
    DIRECTOR("директор"),
    CHIEFENGENEER("главный инженер"),
    SECRETARYMANAGER("секретарь приемной руководителя"),
    DEPUTYDIRECTOROFPRODUCTION("зам. Директора по производству"),
    DEPUTYDIRECTOROFSUPPLYMENT("зам. Директора по снабжению"),
    STAFFSPECIALIST("ведущий специалист по кадрам"),
    CHIEFACCOUNTANT("главный бухгалтер"),
    ACCOUNTANT("бухгалтер"),
    CHIEFPEO("начальник ПЭО"),
    DEPUTYCHIEFPEO("зам. Начальника ПЭО"),
    LEADINGENGENEEROFORGANIZATIONANDNORMALIZATIONOFLABOR("ведущий инженер по организации и нормированию труда"),
    CHIEFBPANDM("начальник БПиМ"),
    ENGINEERBPANDM("инженер БПиМ"),
    CHIEFTECHNOLGYANDCONSTRUCTIONDEPARTMENT("начальник технологическо-конструкторского бюро"),
    ENGINEERCONSTRUCTOR("инженер-конструктор"),
    CHIEFOTK("начальник ОТК"),
    MASTEROTK("мастер ОТК"),
    CHIEFOFLABORATORY("начальник лаборатории"),
    CHIEFRSU("начальник РСУ"),
    LEADINGENGENEEROFLABORSAFETY("ведущий инженер по охране труда"),
    LEADINGENGENEEROFMATERIALANDTECHNICALSUPPLYMENT("ведущий инженер материально-технического снабжения"),
    MECHANICOFAUTOTRANSPORT("механик по автотранспорту"),
    CHIEFENERGETIC("главный энергетик"),
    ENERGETICWORKSHOP3("энергетик цеха №3"),
    ENERGETICWORKSHOP9("энергетик цеха №9"),
    CHIEFBSC("начальник БСЦ"),
    MASTERBSC("мастер БСЦ"),
    MECHANICENERGETIC("механик-энергетик"),
    WORKDISTRIBUTORBSC("распределитель работ БСЦ"),
    CHIEFUKANDRP("начальник УКиРП"),
    MASTER("мастер"),
    CHIEFDISPATCHERUKANDRP("старший диспетчер УКиРП"),
    CHIEFWORKSHOP3("начальник цеха №3"),
    MASTERWORKSHOP3("мастер цеха №3"),
    CHIEFWORKSHOP8("начальник цеха №8"),
    MASTERWORKSHOP8("мастер цеха №8"),
    CHIEFWORKSHOP9("начальник цеха №9"),
    MASTERWORKSHOP9("мастер цеха №9"),
    DISPATCHER("диспетчер"),
    DRIVERLIGHTAUTO("водитель л/а"),
    DRIVERGAZEL("водитель ГАЗель"),
    DRIVERMAZ("водитель МАЗа"),
    DRIVERTRACTOR("тракторист"),
    PLUMBER("сантехник"),
    AUTOWELDER("автосварщик"),
    CRANEOPERATOR("машинист крана"),
    WATCHMAN("сторож"),
    CLEANER("уборщик"),
    DEVELOPER("программист"),
    OPERATOR("связист"),
    CHIEFMEDICINEDEPARTMENT("заведущий здравпунктом"),
    DEFAULTPOST("Должность")
    ;

    private final String title;
    private final ChoiceBox<PostView> choiceBox;

    PostView(String title) {
        this.title = title;
        this.choiceBox = new ChoiceBox<>();
    }

    public static PostView postByName(String string) {
        PostView[] values = PostView.values();
        for (PostView value : values) {
            if (value.title.equals(string)) return value;
        }
        return PostView.DEFAULTPOST;
    }

    public void addToGridPane(GridPane gridPane, int rowNumber){
        Label label = new Label("Должность");
        this.choiceBox.getItems().addAll(values());
        this.choiceBox.setConverter(new StringConverter<PostView>() {
            @Override
            public String toString(PostView object) {
                return object.title;
            }

            @Override
            public PostView fromString(String string) {
                return postByName(string);
            }
        });
        this.choiceBox.setOnAction(ae ->{
            label.setText(choiceBox.getValue().title);
        });
    }

    @Override
    public String requestPart() {
        return "set post = " +
                "'" +
                userChoice() +
                "'";
    }

    @Override
    public String insertRequestValue() {
        return this.userChoice().title;
    }

    @Override
    public String column() {
        return "post";
    }

    public PostView userChoice(){
        return this.choiceBox.getValue();
    }


    /**
     * @param postView - Post, с которым сравнивается наша должность.
     * @return true, если должность совпадает с нашей, или если прилетела
     * дефолтная должность.
     */
    @Override
    public boolean test(PostView postView) {
        if (postView == DEFAULTPOST) return true;
        return this == postView;
    }


    @Override
    public String toString() {
        return this.title;
    }
}
