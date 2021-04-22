package org.example.ui;

import javafx.util.StringConverter;

public class EnumStringConverter extends StringConverter<EnumEntity> {
    @Override
    public String toString(EnumEntity object) {
        return object.title();
    }

    @Override
    public EnumEntity fromString(String string) {
        return null;
    }
}
