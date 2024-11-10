package store.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import store.enums.ErrorMessage;

public class CommonUtil {
    public static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_TYPE.getMessage());
        }
    }

    public static void validateDate(String date) {
        try {
            LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE_TYPE.getMessage());
        }
    }
}
