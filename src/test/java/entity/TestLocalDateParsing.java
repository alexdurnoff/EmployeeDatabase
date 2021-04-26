package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestLocalDateParsing {
    private final String value = "2021-04-29";

    @Test
    public void testParsing(){
            LocalDate localDate = LocalDate.parse(value);
        System.out.printf(localDate.toString());

    }
}
