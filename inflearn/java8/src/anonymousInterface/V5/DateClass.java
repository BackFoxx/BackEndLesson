package anonymousInterface.V5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateClass {
    public static void main(String[] args) {
//        Instant instant = Instant.now(); // 그리니치 기준시 UTC
//        System.out.println("instant = " + instant);
//
//        ZoneId zone = ZoneId.systemDefault();
//        ZonedDateTime zonedDateTime = instant.atZone(zone);
//        System.out.println("zone = " + zone);
//        System.out.println("zonedDateTime = " + zonedDateTime);

//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("now = " + now);
//
//        LocalDateTime birthDay = LocalDateTime.of(2001, Month.FEBRUARY, 1, 0, 0);
//        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
//        System.out.println("nowInKorea = " + nowInKorea);

        LocalDate now = LocalDate.now();
        LocalDate birthDay = LocalDate.of(2001, Month.FEBRUARY, 1);

        long between = ChronoUnit.DAYS.between(now, birthDay);
        System.out.println("between = " + between);
//        Period between = Period.between(now, birthDay);
//        System.out.println("between = " + between);

//        Instant now = Instant.now();
//        Instant plus = now.plus(10, ChronoUnit.SECONDS);
//        Duration between = Duration.between(now, plus);
//        System.out.println("between = " + between.getSeconds());

//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM*dd*yyyy");
//        System.out.println(now.format(dateTimeFormatter));

//        LocalDate parse = LocalDate.parse("07*15*1982", dateTimeFormatter);
//        System.out.println("parse = " + parse);
    }
}
