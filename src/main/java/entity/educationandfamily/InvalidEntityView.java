package entity.educationandfamily;

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
        return "invalid_yes_or_now";
    }

    @Override
    protected String column2Header() {
        return "invalid";
    }
}