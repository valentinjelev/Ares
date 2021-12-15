package me.vzhelev.ares.utils;

import java.util.logging.Logger;

public class LoggerUtil {
    private Logger logger = Logger.getLogger("Minecraft");

    public LoggerUtil() {
    }

    public void info(String message) {
        this.logger.info(message);
    }

    public void warning(String message) {
        this.logger.warning(message);
    }
}

