package me.vzhelev.ares.utils;

public class TimeUtil {
    public TimeUtil() {
    }

    public static long getTimeDifference(long millis) {
        return System.currentTimeMillis() - millis;
    }
}
