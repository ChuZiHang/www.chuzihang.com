package com.chuzihang.lesson.designpatterns.factorymethodpattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        Logger logger = new FileLogger();
        return logger;
    }
}
