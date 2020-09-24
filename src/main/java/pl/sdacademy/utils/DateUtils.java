package pl.sdacademy.utils;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateUtils {

    public long countDays(LocalDate earlierDate, LocalDate laterDate) {
        return DAYS.between(earlierDate, laterDate);
    }
}
