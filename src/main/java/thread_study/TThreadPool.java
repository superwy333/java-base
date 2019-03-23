package thread_study;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2019/3/20.
 */
public class TThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(5); // 创建含有5个线程的线程池

        for (int i=0;i<10;i++) { // 传10个任务
            service.execute(() -> {// 往线程池里面传任务并执行
                try {
                    TimeUnit.MILLISECONDS.sleep(500); // 睡0.5秒之后打印当前线程的名字
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        // java.util.concurrent.ThreadPoolExecutor@21a06946[Running, pool size = 5, active threads = 5, queued tasks = 5, completed tasks = 0]
        // 这里一共5个线程，传了10个任务，所以5个线程都激活了并且队列中的任务为5个
        service.shutdown(); // 正常关闭线程池，会等待所有任务执行完之后才会关闭
        //service.shutdownNow();// 强行关闭线程池，不等待任务执行完，有正在执行的任务的时候可能会抛出异常
        System.out.println(service.isTerminated()); // 线程池中的任务是否全部执行完成？ false
        System.out.println(service.isShutdown()); // 线程池是否关闭？ true，代表正在关闭的过程之中
        System.out.println(service);
        // java.util.concurrent.ThreadPoolExecutor@21a06946[Shutting down, pool size = 5, active threads = 5, queued tasks = 5, completed tasks = 0]

        TimeUnit.SECONDS.sleep(5); // 等待5秒之后，线程池中所有的任务都执行完了
        System.out.println(service.isTerminated()); // true
        System.out.println(service.isShutdown()); // true
        System.out.println(service);
        // java.util.concurrent.ThreadPoolExecutor@21a06946[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 10]
    }
}
