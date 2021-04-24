package org.example.ui;

import javafx.util.StringConverter;

/**
 * Часть сведений о сотруднике в виде перечисления.
 */
public interface EnumEntity {
    String labelName();
    String columnName();
    String title();
    EnumEntity[] valueArray();
    EnumEntity defaultValue();
    StringConverter<EnumEntity> stringConverter();

}
