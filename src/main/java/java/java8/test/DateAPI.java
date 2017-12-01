package java.java8.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateAPI {
    public  static void main(String[] args){
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
        System.out.println(legacyDate.getTime());


        System.out.println(ZoneId.getAvailableZoneIds());
// prints all available timezone ids
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());


        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // false
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37


        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(today);
        System.out.println(tomorrow);
        System.out.println(yesterday);
        System.out.println(dayOfWeek);    // FRIDAY



        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DayOfWeek dayOfWeeka = sylvester.getDayOfWeek();
        System.out.println(dayOfWeeka);      // WEDNESDAY
        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER
        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439       .

        Instant instant3 = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();
        Date legacyDate2 = Date.from(instant3);
        System.out.println(legacyDate2);     // Wed Dec 31 23:59:59 CET 2014
    }
}
