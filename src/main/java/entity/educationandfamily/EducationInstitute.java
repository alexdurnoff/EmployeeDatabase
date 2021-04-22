package entity.educationandfamily;

import org.example.ui.TextEntityView;

public class EducationInstitute extends TextEntityView {

    protected EducationInstitute(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "учебное заведение";
    }

    @Override
    protected String ORMCellTitle() {
        return "education_institute";
    }
}