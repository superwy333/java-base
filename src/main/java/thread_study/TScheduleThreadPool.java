package thread_study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TScheduleThreadPool {

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        /**
         * 定时执行任务
         * 三个参数：
         * task
         * 第一个任务之前的延迟
         * 执行间隔
         * 时间单位
         */
        service.scheduleAtFixedRate(() ->
            System.out.println(Thread.currentThread().getName() + " ScheduleThreadPool"),
        0,500, TimeUnit.MILLISECONDS);
    }
}
