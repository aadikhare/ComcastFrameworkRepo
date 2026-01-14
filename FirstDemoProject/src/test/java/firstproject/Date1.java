package firstproject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date1 {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now().plusDays(31);
        LocalDate currentdate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Date after 1 month :" + date.format(formatter));
        System.out.println("CurrentDate : " + currentdate.format(formatter));
    }
}
