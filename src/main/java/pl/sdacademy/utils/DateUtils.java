package pl.sdacademy.utils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateUtils {

    public long countDays(LocalDate earlierDate, LocalDate laterDate) {
        return DAYS.between(earlierDate, laterDate);
    }

    public boolean isDatesDifferent(Collection<LocalDate> localDates) {
        List<LocalDate> collect = localDates.stream()
                .sorted()
                .collect(Collectors.toList());
        boolean flag = true;
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i) == collect.get(i + 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public long countFarthestDateDifference(List<LocalDate> localDates) {
        List<LocalDate> collect = localDates.stream()
                .sorted()
                .collect(Collectors.toList());
        return countDays(collect.get(0), collect.get(collect.size() - 1));
    }
}
