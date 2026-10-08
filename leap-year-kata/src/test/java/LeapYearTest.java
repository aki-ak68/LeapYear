import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeapYearTest {

    private final LeapYear leapYear = new LeapYear();

    @ParameterizedTest
    @ValueSource(ints = {2017, 2018, 2019})
    void shouldReturnFalseWhenYearIsNotDivisibleByFour(int year) {
        assertFalse(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {2008, 2012, 2016})
    void shouldReturnTrueWhenYearIsDivisibleByFourButNotByHundred(int year) {
        assertTrue(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {1700, 1800, 1900, 2100})
    void shouldReturnFalseWhenYearIsDivisibleByHundredButNotFourHundred(int year) {
        assertFalse(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {1600, 2000, 2400})
    void shouldReturnTrueWhenYearIsDivisibleByFourHundred(int year) {
        assertTrue(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, true",
            "99, false",
            "100, false",
            "399, false",
            "400, true",
            "401, false"
    })
    void shouldHandleBoundaryYears(int year, boolean expected) {
        assertEquals(expected, leapYear.isLeapYear(year));
    }

    @Test
    void shouldThrowExceptionWhenYearIsZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> leapYear.isLeapYear(0)
        );
    }

    @Test
    void shouldThrowExceptionWhenYearIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> leapYear.isLeapYear(-1)
        );
    }
}