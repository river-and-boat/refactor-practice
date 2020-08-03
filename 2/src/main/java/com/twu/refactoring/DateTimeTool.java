package com.twu.refactoring;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/3 19:56
 * @Description ***
 **/
public class DateTimeTool {

    public static int convertYear(String dateAndTimeString) throws IllegalArgumentException {
        int year = convertTimeByIndex(0, 4, dateAndTimeString, "Year");
        if (year < 2000 || year > 2012)
            throw new IllegalArgumentException("Year cannot be less than 2000 or more than 2012");

        return year;
    }

    public static int convertMonth(String dateAndTimeString) {
        int month = convertTimeByIndex(5, 7, dateAndTimeString, "Month");
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month cannot be less than 1 or more than 12");
        return month;
    }

    public static int convertDate(String dateAndTimeString) {
        int date = convertTimeByIndex(8, 10, dateAndTimeString, "Date");
        if (date < 1 || date > 31)
            throw new IllegalArgumentException("Date cannot be less than 1 or more than 31");
        return date;
    }

    public static int convertHour(String dateAndTimeString) {
        int hour;
        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
        } else {
            hour = convertTimeByIndex(11, 13, dateAndTimeString, "Hour");
            if (hour < 0 || hour > 23)
                throw new IllegalArgumentException("Hour cannot be less than 0 or more than 23");
        }
        return hour;
    }

    public static int convertMinute(String dateAndTimeString) {
        int minute;
        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            minute = 0;
        } else {
            minute = convertTimeByIndex(14, 16, dateAndTimeString, "Minute");
            if (minute < 0 || minute > 59)
                throw new IllegalArgumentException("Minute cannot be less than 0 or more than 59");
        }
        return minute;
    }

    private static int convertTimeByIndex(int startIndex, int endIndex,
                                          String dateAndTimeString, String type) {
        try {
            String timeStr = dateAndTimeString.substring(startIndex, endIndex);
            return Integer.parseInt(timeStr);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(type + " string is less than " + (endIndex - startIndex) + " characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(type + " is not an integer");
        }
    }
}
