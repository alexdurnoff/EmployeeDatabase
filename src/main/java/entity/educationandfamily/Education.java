package entity.educationandfamily;

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

    public static Education educationByTitle(String title){
        Education[] values = values();
        for (Education value : values) {
            if (value.title.equals(title)) return value;
        }
        return DEFAULT;
    }
}
