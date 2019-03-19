package thread_study;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TSynchronousQueue {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>(); //容量为零的Queue

        new Thread(() -> { // 先启动消费者线程
            try {
                System.out.println(queue.take());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //queue.add("aaa"); // 使用add方法会抛异常
        queue.put("aaa");

        /*new Thread(() -> { // 后启动消费者线程的情况下，上面的queue.queue.put("aaa")会阻塞
            try {
                System.out.println(queue.take());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }
}
