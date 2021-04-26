package entity.job.agreement;

import javafx.util.StringConverter;
import org.example.ui.EnumEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public enum AgreementEnumEntity implements EnumEntity {
    EmployeeContract("трудовой контракт"),
    ContractAgreement("договор подряда"),
    DEFAULTAGREEMENT("трудовое соглашение");

    private final String title;
    private LocalDate localDateFrom;
    private LocalDate localDateTo;

    AgreementEnumEntity(String title) {
        this.title = title;
        this.localDateFrom = LocalDate.of(1900, 11,11);
        this.localDateTo = LocalDate.of(1900, 11,11);

    }

    AgreementEnumEntity(String title, LocalDate from, LocalDate to){
        this(title);
        this.localDateTo = to;
        this.localDateFrom = from;
    }

    AgreementEnumEntity(String title, String from, String to){
        this.title = title;
        try {
            this.localDateFrom = LocalDate.parse(from);
            this.localDateTo = LocalDate.parse(title);
        } catch (Exception e) {
            e.printStackTrace();
            this.localDateFrom = LocalDate.of(1900, 11,11);
            this.localDateTo = LocalDate.of(1900, 11,11);
        }

    }

    @Override
    public String labelName() {
        return "трудовое соглашение";
    }





    @Override
    public String columnName() {
        return "agreement, date_from, date_to";
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public EnumEntity[] valueArray() {
        return values();
    }

    @Override
    public EnumEntity defaultValue() {
        return DEFAULTAGREEMENT;
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

    public static AgreementEnumEntity entityByTitle(String title){
        AgreementEnumEntity[] values = values();
        for (AgreementEnumEntity value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULTAGREEMENT;
    }


    public static AgreementEnumEntity entityFromResultSet(ResultSet resultSet){
        try {
            String title = resultSet.getString(6);
            AgreementEnumEntity entity = entityByTitle(title);
            try {
                entity.localDateFrom = LocalDate.parse(resultSet.getString(7));
            } catch (Exception exception) {
                entity.localDateFrom = LocalDate.of(1900, 11, 11);
            }
            try {
                entity.localDateTo = LocalDate.parse(resultSet.getString(8));
            } catch (Exception exception) {
                entity.localDateTo = LocalDate.of(1900, 11, 11);
            }
            return entity;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return DEFAULTAGREEMENT;
        }
    }

    public DatePickerFrom datePickerFrom(){
        return new DatePickerFrom(localDateFrom);
    }

    public DatePickerTo datePickerTo(){
        return new DatePickerTo(localDateTo);
    }
}
