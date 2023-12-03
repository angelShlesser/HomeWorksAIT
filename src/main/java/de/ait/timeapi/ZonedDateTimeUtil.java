package de.ait.timeapi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeUtil {
    public static void main(String[] args) {
        // Получение текущего времени в соответствии с временной зоной
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Текущее время с учетом временной зоны: " + zonedDateTime);

        // Вывод всех доступных идентификаторов временных зон
        System.out.println("Доступные идентификаторы временных зон:");
        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            //System.out.println(zoneId);
        }
        // Установка временной зоны "US/Eastern"
        ZoneId zoneIdUSEastern = ZoneId.of("US/Eastern");

        // Получение текущего времени в соответствии с временной зоной "US/Eastern"
        ZonedDateTime zonedDateTimeUSEastern = ZonedDateTime.now(zoneIdUSEastern);

        // Вывод текущего времени во временной зоне "US/Eastern"
        System.out.println("Текущее время в временной зоне US/Eastern: " + zonedDateTimeUSEastern);

        // Вывод различной информации о времени во временной зоне "US/Eastern"
        System.out.println("Месяц: " + zonedDateTimeUSEastern.getMonthValue());
        System.out.println("Смещение от UTC: " + zonedDateTimeUSEastern.getOffset());
        System.out.println("День года: " + zonedDateTimeUSEastern.getDayOfYear());
    }
}