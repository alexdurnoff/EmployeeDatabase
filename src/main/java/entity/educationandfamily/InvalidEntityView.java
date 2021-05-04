package entity.educationandfamily;

import hibernate.HibernateEntity;
import org.example.ui.RadioButtonEntityView;

public class InvalidEntityView extends RadioButtonEntityView {

    public InvalidEntityView(String yesOrNo, String content) {
        super(yesOrNo, content);
    }

    @Override
    protected String labelHeader() {
        return "наличие в семье инвалидов";
    }

    @Override
    protected String column1Header() {
        return "invalid_yes_or_no";
    }

    @Override
    protected String column2Header() {
        return "invalid";
    }


    @Override
    public HibernateEntity entity() {
        return null;
    }
}
