package entity.agreement;

import javafx.scene.control.ChoiceBox;

/**
 * Класс для получения от пользователя типа трудового соглашения.
 * Нужен, чтобы иметь возможность достучаться до него через Reflection
 * и достать значение.
 */
public class AgreementChoiceBox extends ChoiceBox<EmploymentAgreement> {
}
