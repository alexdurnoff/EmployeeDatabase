package org.example.ui;

import entity.Post;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.Collections;

/**
 * Выпадающий список должностей, которые может занимать сотрудник.
 */
public class PostChoiceBox extends ChoiceBox<Post> {

    public PostChoiceBox(){
        this.getItems().addAll(Arrays.asList(Post.values()));
        this.setConverter(new StringConverter<Post>() {
            @Override
            public String toString(Post object) {
                return object.toString();
            }

            @Override
            public Post fromString(String string) {
                if (string.equals("директор")) return Post.DIRECTOR;
                if (string.equals("главный инженер")) return Post.CHIEFENGENEER;
                if (string.equals("секретарь приемной руководителя")) return Post.SECRETARYMANAGER;
                if (string.equals("зам. Директора по производству")) return Post.DEPUTYDIRECTOROFPRODUCTION;
                if (string.equals("зам. Директора по снабжению")) return Post.DEPUTYDIRECTOROFSUPPLYMENT;
                if (string.equals("ведущий специалист по кадрам")) return Post.STAFFSPECIALIST;
                if (string.equals("главный бухгалтер")) return Post.CHIEFACCOUNTANT;
                if (string.equals("бухгалтер")) return Post.ACCOUNTANT;
                if (string.equals("начальник ПЭО")) return Post.CHIEFPEO;
                if (string.equals("зам. Начальника ПЭО")) return Post.DEPUTYCHIEFPEO;
                if (string.equals("ведущий инженер по организации и нормированию труда")) return Post.LEADINGENGENEEROFORGANIZATIONANDNORMALIZATIONOFLABOR;
                if (string.equals("начальник БПиМ")) return Post.CHIEFBPANDM;
                if (string.equals("инженер БПиМ")) return Post.ENGINEERBPANDM;
                if (string.equals("начальник технологическо-конструкторского бюро")) return Post.CHIEFTECHNOLGYANDCONSTRUCTIONDEPARTMENT;
                if (string.equals("инженер-конструктор")) return Post.ENGINEERCONSTRUCTOR;
                if (string.equals("начальник ОТК")) return Post.CHIEFOTK;
                if (string.equals("мастер ОТК")) return Post.MASTEROTK;
                if (string.equals("начальник лаборатории")) return Post.CHIEFOFLABORATORY;
                if (string.equals("начальник РСУ")) return Post.CHIEFRSU;
                if (string.equals("ведущий инженер по охране труда")) return Post.LEADINGENGENEEROFLABORSAFETY;
                if (string.equals("ведущий инженер материально-технического снабжения")) return Post.LEADINGENGENEEROFMATERIALANDTECHNICALSUPPLYMENT;
                if (string.equals("механик по автотранспорту")) return Post.MECHANICOFAUTOTRANSPORT;
                if (string.equals("главный энергетик")) return Post.CHIEFENERGETIC;
                if (string.equals("энергетик цеха №3")) return Post.ENERGETICWORKSHOP3;
                if (string.equals("энергетик цеха №9")) return Post.ENERGETICWORKSHOP9;
                if (string.equals("начальник БСЦ")) return Post.CHIEFBSC;
                if (string.equals("мастер БСЦ")) return Post.MASTERBSC;
                if (string.equals("механик-энергетик")) return Post.MECHANICENERGETIC;
                if (string.equals("распределитель работ БСЦ")) return Post.WORKDISTRIBUTORBSC;
                if (string.equals("начальник УКиРП")) return Post.CHIEFUKANDRP;
                if (string.equals("мастер")) return Post.MASTER;
                if (string.equals("старший диспетчер УКиРП")) return Post.CHIEFDISPATCHERUKANDRP;
                if (string.equals("начальник цеха №3")) return Post.CHIEFWORKSHOP3;
                if (string.equals("мастер цеха №3")) return Post.MASTERWORKSHOP3;
                if (string.equals("начальник цеха №8")) return Post.CHIEFWORKSHOP8;
                if (string.equals("мастер цеха №8")) return Post.MASTERWORKSHOP8;
                if (string.equals("начальник цеха №9")) return Post.CHIEFWORKSHOP9;
                if (string.equals("мастер цеха №9")) return Post.MASTERWORKSHOP9;
                if (string.equals("диспетчер")) return Post.DISPATCHER;
                if (string.equals("водитель л/а")) return Post.DRIVERLIGHTAUTO;
                if (string.equals("водитель ГАЗель")) return Post.DRIVERGAZEL;
                if (string.equals("водитель МАЗа")) return Post.DRIVERMAZ;
                if (string.equals("тракторист")) return Post.DRIVERTRACTOR;
                if (string.equals("сантехник")) return Post.PLUMBER;
                if (string.equals("автосварщик")) return Post.AUTOWELDER;
                if (string.equals("машинист крана")) return Post.CRANEOPERATOR;
                if (string.equals("сторож")) return Post.WATCHMAN;
                if (string.equals("уборщик")) return Post.CLEANER;
                if (string.equals("программист")) return Post.DEVELOPER;
                if (string.equals("связист")) return Post.OPERATOR;
                if (string.equals("заведущий здравпунктом")) return Post.CHIEFMEDICINEDEPARTMENT;
                return Post.DEFAULTPOST;
            }
        });
    }

}
