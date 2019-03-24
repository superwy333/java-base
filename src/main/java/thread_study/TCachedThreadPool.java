package thread_study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TCachedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service); // 这个时候线程池里面没有线程，也没有任务
        // java.util.concurrent.ThreadPoolExecutor@5cbc508c[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]

        for (int i =0;i<2;i++) {
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " TCachedThreadPool");
            });
        }

        System.out.println(service); // 这个时候有两个线程存在，两个任务在跑
        // java.util.concurrent.ThreadPoolExecutor@5cbc508c[Running, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 0]
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println(service); // 这个时候有两个线程存在，任务跑完了
        // java.util.concurrent.ThreadPoolExecutor@5cbc508c[Running, pool size = 2, active threads = 0, queued tasks = 0, completed tasks = 2]
        TimeUnit.MILLISECONDS.sleep(60000);
        System.out.println(service); // 这个时候没有线程了
        // java.util.concurrent.ThreadPoolExecutor@5cbc508c[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 2]
    }
}
