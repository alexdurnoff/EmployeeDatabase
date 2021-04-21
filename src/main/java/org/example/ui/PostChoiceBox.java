package org.example.ui;

import entity.post.PostView;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

import java.util.Arrays;

/**
 * Выпадающий список должностей, которые может занимать сотрудник.
 */
public class PostChoiceBox extends ChoiceBox<PostView> {

    public PostChoiceBox(){
        this.getItems().addAll(Arrays.asList(PostView.values()));
        this.setConverter(new StringConverter<PostView>() {
            @Override
            public String toString(PostView object) {
                return object.toString();
            }

            @Override
            public PostView fromString(String string) {
                if (string.equals("директор")) return PostView.DIRECTOR;
                if (string.equals("главный инженер")) return PostView.CHIEFENGENEER;
                if (string.equals("секретарь приемной руководителя")) return PostView.SECRETARYMANAGER;
                if (string.equals("зам. Директора по производству")) return PostView.DEPUTYDIRECTOROFPRODUCTION;
                if (string.equals("зам. Директора по снабжению")) return PostView.DEPUTYDIRECTOROFSUPPLYMENT;
                if (string.equals("ведущий специалист по кадрам")) return PostView.STAFFSPECIALIST;
                if (string.equals("главный бухгалтер")) return PostView.CHIEFACCOUNTANT;
                if (string.equals("бухгалтер")) return PostView.ACCOUNTANT;
                if (string.equals("начальник ПЭО")) return PostView.CHIEFPEO;
                if (string.equals("зам. Начальника ПЭО")) return PostView.DEPUTYCHIEFPEO;
                if (string.equals("ведущий инженер по организации и нормированию труда")) return PostView.LEADINGENGENEEROFORGANIZATIONANDNORMALIZATIONOFLABOR;
                if (string.equals("начальник БПиМ")) return PostView.CHIEFBPANDM;
                if (string.equals("инженер БПиМ")) return PostView.ENGINEERBPANDM;
                if (string.equals("начальник технологическо-конструкторского бюро")) return PostView.CHIEFTECHNOLGYANDCONSTRUCTIONDEPARTMENT;
                if (string.equals("инженер-конструктор")) return PostView.ENGINEERCONSTRUCTOR;
                if (string.equals("начальник ОТК")) return PostView.CHIEFOTK;
                if (string.equals("мастер ОТК")) return PostView.MASTEROTK;
                if (string.equals("начальник лаборатории")) return PostView.CHIEFOFLABORATORY;
                if (string.equals("начальник РСУ")) return PostView.CHIEFRSU;
                if (string.equals("ведущий инженер по охране труда")) return PostView.LEADINGENGENEEROFLABORSAFETY;
                if (string.equals("ведущий инженер материально-технического снабжения")) return PostView.LEADINGENGENEEROFMATERIALANDTECHNICALSUPPLYMENT;
                if (string.equals("механик по автотранспорту")) return PostView.MECHANICOFAUTOTRANSPORT;
                if (string.equals("главный энергетик")) return PostView.CHIEFENERGETIC;
                if (string.equals("энергетик цеха №3")) return PostView.ENERGETICWORKSHOP3;
                if (string.equals("энергетик цеха №9")) return PostView.ENERGETICWORKSHOP9;
                if (string.equals("начальник БСЦ")) return PostView.CHIEFBSC;
                if (string.equals("мастер БСЦ")) return PostView.MASTERBSC;
                if (string.equals("механик-энергетик")) return PostView.MECHANICENERGETIC;
                if (string.equals("распределитель работ БСЦ")) return PostView.WORKDISTRIBUTORBSC;
                if (string.equals("начальник УКиРП")) return PostView.CHIEFUKANDRP;
                if (string.equals("мастер")) return PostView.MASTER;
                if (string.equals("старший диспетчер УКиРП")) return PostView.CHIEFDISPATCHERUKANDRP;
                if (string.equals("начальник цеха №3")) return PostView.CHIEFWORKSHOP3;
                if (string.equals("мастер цеха №3")) return PostView.MASTERWORKSHOP3;
                if (string.equals("начальник цеха №8")) return PostView.CHIEFWORKSHOP8;
                if (string.equals("мастер цеха №8")) return PostView.MASTERWORKSHOP8;
                if (string.equals("начальник цеха №9")) return PostView.CHIEFWORKSHOP9;
                if (string.equals("мастер цеха №9")) return PostView.MASTERWORKSHOP9;
                if (string.equals("диспетчер")) return PostView.DISPATCHER;
                if (string.equals("водитель л/а")) return PostView.DRIVERLIGHTAUTO;
                if (string.equals("водитель ГАЗель")) return PostView.DRIVERGAZEL;
                if (string.equals("водитель МАЗа")) return PostView.DRIVERMAZ;
                if (string.equals("тракторист")) return PostView.DRIVERTRACTOR;
                if (string.equals("сантехник")) return PostView.PLUMBER;
                if (string.equals("автосварщик")) return PostView.AUTOWELDER;
                if (string.equals("машинист крана")) return PostView.CRANEOPERATOR;
                if (string.equals("сторож")) return PostView.WATCHMAN;
                if (string.equals("уборщик")) return PostView.CLEANER;
                if (string.equals("программист")) return PostView.DEVELOPER;
                if (string.equals("связист")) return PostView.OPERATOR;
                if (string.equals("заведущий здравпунктом")) return PostView.CHIEFMEDICINEDEPARTMENT;
                return PostView.DEFAULTPOST;
            }
        });
    }

}
