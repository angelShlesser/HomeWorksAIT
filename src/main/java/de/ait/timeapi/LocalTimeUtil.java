package de.ait.timeapi;

import java.time.LocalTime;

public class LocalTimeUtil {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime time = LocalTime.of(20,00,00);
        System.out.println(time);

        time = time.plusHours(2);
        time = time.minusHours(1);
        time = time.plusSeconds(3009);
        System.out.println(time);

        LocalTime localFromSeconds = LocalTime.ofSecondOfDay(3009);
        System.out.println(localFromSeconds);

        System.out.println(time.getMinute());
        System.out.println(time.getHour());
    }

}
