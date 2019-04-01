package com.chuzihang.lesson.designpatterns.factorymethodpattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        Logger logger = new DatabaseLogger();
        return logger;
    }
}
