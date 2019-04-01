package com.chuzihang.lesson.designpatterns.factorymethodpattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("文件记录日志");
    }
}
