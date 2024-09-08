package by.tms.lesson28.onl30.jsp.servants;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.DATE_TIME_LOGGER_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.LOGGER_MESSAGE_TEMPLATE;

// todo сделать логирование в файл!

public class MyLogger {
    public static void logIn(String messageCustomer) {
        System.out.printf(LOGGER_MESSAGE_TEMPLATE.formatted(getStringDateTime(), messageCustomer));
    }

    public static String getStringDateTime() {
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_LOGGER_TEMPLATE);
        return dateTime.format(dateTimeFormatter);
    }
}
