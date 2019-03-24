package thread_study;

import java.util.concurrent.*;

public class TFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<Integer> f = service.submit(() -> {
            System.out.println("start sleep...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("end sleep...");
            return 1000;
        });

        System.out.println(f.isDone()); // 是否执行完成
        System.out.println(f.get());
        System.out.println(f.isDone());

        /*FutureTask<Integer> task = new FutureTask<>(() -> { // FutureTask构造器可以传Runnable或Callable任务
            System.out.println("start sleep...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("end sleep...");
            return 1000;
        });
        new Thread(task).start(); // 和runnable接口任务一样直接扔到new Thread新建的线程中并启动
        TimeUnit.SECONDS.sleep(1);
        System.out.println("wait...");
        System.out.println(task.get()); // 获取FutureTask中任务的执行结果,get()方法是个阻塞方法；会一直等待FutureTask中任务执行结束*/
    }
}
