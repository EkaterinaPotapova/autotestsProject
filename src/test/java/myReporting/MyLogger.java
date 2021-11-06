package myReporting;

import org.apache.log4j.Logger;

/**
 * Этот класс для удобства использования log4j, чтобы не создавать инстанс логгера.
 * Здесь методы статик и можно сразу вызывать методы логгера например MyLogger.debug("This is a debug message");
 */
public class MyLogger {

    public static Logger logger = Logger.getLogger(MyLogger.class);

    public static void error(String message){
        logger.error(message);
    }

    public static void log(String message){
        logger.info(message);
    }

    public static void warn(String message){
        logger.warn(message);
    }

    public static void debug(String message){
        logger.debug(message);
    }

    public static void info(String message){
        logger.info(message);
    }




}
