package entity.job;

import entity.EntityView;
import hibernate.HibernateEntity;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.example.ui.HeaderEntityView;

/**
 * Заголовок сведений о работе в карточке сотрудника.
 */
public class JobHeaderView extends HeaderEntityView {

    @Override
    protected String labelTitle() {
        return "сведения о работе";
    }

    @Override
    public String column() {
        return null;
    }

    @Override
    public HibernateEntity entity() {
        return null;
    }
}
