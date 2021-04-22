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
    protected String ORMCellTitle() {
        return "living_area";
    }
}
