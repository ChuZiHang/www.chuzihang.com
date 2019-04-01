package com.chuzihang.lesson.designpatterns.factorymethodpattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class Test {

    public static void main(String[] args) {
        LoggerFactory loggerFactory;
        Logger logger;

        loggerFactory = new FileLoggerFactory();
        logger = loggerFactory.createLogger();

        logger.writeLog();
    }
}
