package entity;

import entity.job.DivisionView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionViewTest {

    @Test
    void test1() {
        DivisionView divisionView = DivisionView.ADMINISTRATION;
        DivisionView sameDivisionView = DivisionView.ADMINISTRATION;
        DivisionView otherDivisionView = DivisionView.LABORATORY;
        DivisionView defaultDivisionView = DivisionView.DEFAULTDIVISION;
        Assertions.assertTrue(divisionView.test(sameDivisionView));
        Assertions.assertTrue(divisionView.test(defaultDivisionView));
        Assertions.assertFalse(divisionView.test(otherDivisionView));
        assertSame(divisionView, sameDivisionView);
    }
}