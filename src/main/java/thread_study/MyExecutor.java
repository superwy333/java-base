package thread_study;

import java.util.concurrent.Executor;

/**
 * Created by wangyang on 2019/3/20.
 */
public class MyExecutor implements Executor {

    public static void main(String[] args) {

        new MyExecutor().execute(() -> System.out.println(Thread.currentThread().getName() + " hello executor"));

    }

    @Override
    public void execute(Runnable command) {
        //command.run(); // 在这个方法里可以直接执行接收到的任务
        // 也可以新建线程来执行任务
        new Thread(command,"t1").start();
        new Thread(command,"t2").start();
    }
}
