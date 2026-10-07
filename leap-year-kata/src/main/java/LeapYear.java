public class LeapYear {
    public boolean isLeapYear(int year) {
        validateYear(year);

        return year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0);
    }

    private void validateYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be greater than zero");
        }
    }
}