package com.example.nguyenkhoahung.rentalroommanagement.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    /**
     * Convert time in millis to formatted string
     * @param millis millis
     * @return formatted string
     */
    public static String getDateByLocalFormat(long millis) {
        Date date = new Date();
        date.setTime(millis);
        return new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(date);
    }

    /**
     * Get current time and convert to formatted string
     * @return current time in formatted string
     */
    public static String getNow() {
        return getDateByLocalFormat(getCurrentTimeInMillis());
    }

    /**
     * Get current time in millisecond
     * @return current time
     */
    public static long getCurrentTimeInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * Convert a duration to formatted HH:mm:ss
     * @param dur duration
     * @return HH:mm:ss
     */
    public static String durationToTimeStamp(long dur) {
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long elapsedHours = dur / hoursInMilli;
        dur = dur % hoursInMilli;
        long elapsedMinutes = dur / minutesInMilli;
        dur = dur % minutesInMilli;
        long elapsedSeconds = dur / secondsInMilli;

        String hStr = String.valueOf(elapsedHours);
        String hourStr = hStr.length() == 1 ? "0" + hStr : hStr;
        String mStr = String.valueOf(elapsedMinutes);
        String minuStr = mStr.length() == 1 ? "0" + mStr : mStr;
        String sStr = String.valueOf(elapsedSeconds);
        String secondStr = sStr.length() == 1 ? "0" + sStr : sStr;
        return hourStr + ":" + minuStr + ":" + secondStr;
    }
}
