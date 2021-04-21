package entity;

import entity.tableNumber.TableNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TableNumberTest {

    @Test
    void test1() {
        TableNumber tableNumber = new TableNumber("134");
        TableNumber defaultTableNumber = new TableNumber();
        TableNumber sameTableNumber = new TableNumber("134");
        TableNumber otherTableNumber = new TableNumber("125");
        TableNumber incorrectTableNumber = new TableNumber("fdfd");
        Assertions.assertTrue(tableNumber.test(defaultTableNumber));
        Assertions.assertFalse(tableNumber.test(incorrectTableNumber));
        Assertions.assertTrue(tableNumber.test(sameTableNumber));
        Assertions.assertFalse(tableNumber.test(otherTableNumber));
    }


}