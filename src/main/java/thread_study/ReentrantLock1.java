package thread_study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangyang on 2019/3/9.
 */
public class ReentrantLock1 {

    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i=0;i<10;i++) {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2() {
        lock.lock();
        System.out.println("m2");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 r = new ReentrantLock1();

        // 执行完m1之后才会执行m2
        new Thread(() -> r.m1()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> r.m2()).start();
    }
}
