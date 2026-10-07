import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LeapYearTest {

    private final LeapYear leapYear = new LeapYear();

    @Test
    void shouldReturnFalseWhenYearIsNotDivisibleByFour() {
        assertFalse(leapYear.isLeapYear(2017));
    }
}
