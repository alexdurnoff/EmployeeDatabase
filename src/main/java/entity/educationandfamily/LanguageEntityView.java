package entity.educationandfamily;

import hibernate.HibernateEntity;
import org.example.ui.RadioButtonEntityView;

public class LanguageEntityView extends RadioButtonEntityView {

    public LanguageEntityView(String yesOrNo, String content) {
        super(yesOrNo, content);
    }

    @Override
    protected String labelHeader() {
        return "знание иностранного языка";
    }

    @Override
    protected String column1Header() {
        return "language_yes_or_no";
    }

    @Override
    protected String column2Header() {
        return "language";
    }


    @Override
    public HibernateEntity entity() {
        return null;
    }
}
