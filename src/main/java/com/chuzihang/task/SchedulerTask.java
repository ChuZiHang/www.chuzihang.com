package com.chuzihang.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName SchedulerTask
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/4/28 14:45
 * <p>
 * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
 * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行
 **/
@Component
public class SchedulerTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private int count = 0;

    /**
     * 两种都表示每隔六秒打印一下内容。
     */
    @Scheduled(cron = "*/6 * * * * ?")
    private void test1() {
        logger.info("this is scheduler task runing  " + (count++));
    }

    /**
     * 两种都表示每隔六秒打印一下内容。
     */
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        logger.info("现在时间：" + LocalDateTime.now());
    }
}
