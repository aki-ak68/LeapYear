import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearTest {

    private final LeapYear leapYear = new LeapYear();

    @Test
    void shouldReturnFalseWhenYearIsNotDivisibleByFour() {
        assertFalse(leapYear.isLeapYear(2017));
    }

    @Test
    void shouldReturnTrueWhenYearIsDivisibleByFour() {
        assertTrue(leapYear.isLeapYear(2008));
        assertTrue(leapYear.isLeapYear(2012));
        assertTrue(leapYear.isLeapYear(2016));
    }
}
