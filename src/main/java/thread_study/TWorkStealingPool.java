package thread_study;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TWorkStealingPool {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors()); // 打印CPU核数:12
        ExecutorService service = Executors.newWorkStealingPool(4); // 默认情况根据CPU核数创建线程数, 也可以构造方法自己指定
        System.out.println(service);
        // 指定4个线程：java.util.concurrent.ForkJoinPool@4f47d241[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
        // 默认：java.util.concurrent.ForkJoinPool@4f47d241[Running, parallelism = 12, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
        // 创建5个任务，第一个任务睡1秒，其他的睡2秒；由于只有4个线程，所以第5个任务会等待，第1个任务先执行完，所以必定是第1个线程执行第5个任务
        R task1 = new R(1000);
        R task2 = new R(2000);
        R task3 = new R(2000);
        R task4 = new R(2000);
        R task5 = new R(2000);
        service.execute(task1);
        service.execute(task2);
        service.execute(task3);
        service.execute(task4);
        service.execute(task5);

        // 工作窃取线程池中的线程是守护线程，即主线程结束的话，守护线程还在运行，但是看不到输出，所以这里要阻塞主线程
        TimeUnit.SECONDS.sleep(100000);
        //System.in.read(); // 这个也是阻塞主线程
    }

    static class R implements Runnable {

        int time;

        R(int t) {
            this.time = t;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time + " " + Thread.currentThread().getName());
        }
    }

}
