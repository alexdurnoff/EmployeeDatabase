package entity.educationandfamily;

import javafx.util.StringConverter;
import org.example.ui.EnumEntity;

public enum Education implements EnumEntity {
    GENERIC("общее"),
    GENERICMIDDLE("общее среднее"),
    GENERICSPECIAL("общее специальное"),
    SPECIAL("специальное"),
    MIDDLESPECIAL("среднее специальное"),
    PORFTECH("проофессионально-техническое"),
    HIGHSCOOL("высшее профессиональное"),
    DEFAULT("образование");

    private final String title;

    Education(String title){
        this.title = title;
    }


    @Override
    public String labelName() {
        return "образование";
    }

    @Override
    public String columnName() {
        return "education";
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
        return DEFAULT;
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

    public static Education entityByTitle(String title){
        Education[] values = values();
        for (Education value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULT;
    }
}
