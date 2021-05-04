package entity.job;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.example.ui.TextEntityView;

import java.util.function.Predicate;

public class WorkSchedule extends TextEntityView {

    public WorkSchedule(String textContent) {
        super(textContent);
    }

    @Override
    protected String labelText() {
        return "график работы";
    }

    @Override
    public String column() {
        return "work_schedule";
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
