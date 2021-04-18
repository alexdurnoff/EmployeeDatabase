package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GettingStartedTest {

    @Test
    void test1() {
        GettingStarted gettingStarted = new GettingStarted(LocalDate.of(1975, 1, 7));
        GettingStarted defaultGettingStarted = new GettingStarted();
        GettingStarted sameGettingStarted = new GettingStarted(LocalDate.of(1975, 1, 7));
        GettingStarted otherGettingStarted1 = new GettingStarted(LocalDate.of(1976, 1,7));
        GettingStarted otherGettingStarted2 = new GettingStarted(LocalDate.of(1975, 2, 7));
        GettingStarted otherGettingStarted3 = new GettingStarted(LocalDate.of(1975, 1, 8));
        Assertions.assertTrue(gettingStarted.test(defaultGettingStarted));
        Assertions.assertTrue(gettingStarted.test(sameGettingStarted));
        Assertions.assertFalse(gettingStarted.test(otherGettingStarted1));
        Assertions.assertFalse(gettingStarted.test(otherGettingStarted2));
        Assertions.assertFalse(gettingStarted.test(otherGettingStarted3));
    }
}