package entity.educationandfamily;

import org.example.ui.RadioButtonEntityView;

public class ChildrenEntityView extends RadioButtonEntityView {

    public ChildrenEntityView(String yesOrNo, String content) {
        super(yesOrNo, content);
    }

    @Override
    protected String labelHeader() {
        return "наличие детей до 18 лет";
    }

    @Override
    protected String column1Header() {
        return "children_yes_or_no";
    }

    @Override
    protected String column2Header() {
        return "children";
    }
}
