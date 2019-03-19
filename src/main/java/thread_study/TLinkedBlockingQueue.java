package thread_study;


import java.sql.Time;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2019/3/19.
 */
public class TLinkedBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<String> strs = new LinkedBlockingQueue<>();

        Random r = new Random();

        new Thread(()->{
            for (int i=0;i<100;i++){
                try {
                    strs.put("a"+i); // 阻塞式队列的put()方法在满的时候自己会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();

        for (int j=0;j<10;j++) {
            new Thread(() -> {
                while (true) {
                    try {
                        // 阻塞式队列的take()方法在取不到的时候会等待
                        System.out.println(Thread.currentThread().getName() +" take " + strs.take());
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            },"c"+j).start();
        }
    }
}
