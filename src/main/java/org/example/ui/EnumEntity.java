package org.example.ui;

/**
 * Часть сведений о сотруднике в виде перечисления.
 */
public interface EnumEntity {
    String labelName();
    String columnName();
    String title();
    EnumEntity[] values();
}
