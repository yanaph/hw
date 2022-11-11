package ua.fan.hw18;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("2019/02/03", "2020/03/04", "2021/04/05", "2022/05/06"));
        List<LocalDate> dates = convertStringToDate(stringArrayList);
        System.out.println("Dates: " + dates);
        System.out.printf("Date with year 2022: %b%n", ifContainsYear2022(dates));
    }

    private static List<LocalDate> convertStringToDate(List<String> strings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return strings.stream()
                .map(date -> LocalDate.parse(date, formatter))
                .toList();
    }

    private static boolean ifContainsYear2022(List<LocalDate> dates) {
        return !(dates.stream()
                .filter(localDate -> localDate.getYear() == 2022)
                .toList().isEmpty());
    }
}
