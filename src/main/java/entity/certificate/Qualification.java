package entity.certificate;

import org.example.ui.RadioButtonEntityView;

public class Qualification extends RadioButtonEntityView {

    public Qualification(String yesOrNo, String content) {
        super(yesOrNo, content);
    }

    @Override
    protected String labelHeader() {
        return "присвоена категория/квалификация";
    }

    @Override
    protected String column1Header() {
        return "qualification_yes_or_no";
    }

    @Override
    protected String column2Header() {
        return "qualification";
    }
}
