package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void test1() {
        Division division = Division.ADMINISTRATION;
        Division sameDivision = Division.ADMINISTRATION;
        Division otherDivision = Division.LABORATORY;
        Division defaultDivision = Division.DEFAULTDIVISION;
        Assertions.assertTrue(division.test(sameDivision));
        Assertions.assertTrue(division.test(defaultDivision));
        Assertions.assertFalse(division.test(otherDivision));
        assertSame(division, sameDivision);
    }
}