package me.vzhelev.ares.utils;

public class ColourUtil {
    public ColourUtil() {
    }
    public static String replaceString(String s) {
        return s.replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&l", "§l").replaceAll("&o", "§o").replaceAll("&k", "§k").replaceAll("&r", "§r").replaceAll("&n", "§n").replaceAll("&m", "§m");
    }
}
