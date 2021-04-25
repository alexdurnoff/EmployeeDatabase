package entity.educationandfamily;

import org.example.ui.TextEntityView;

public class LivingAreaEntityView extends TextEntityView {

    protected LivingAreaEntityView(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "обеспеченность жилой площадью";
    }

    @Override
    public String column() {
        return "living_area";
    }
}
