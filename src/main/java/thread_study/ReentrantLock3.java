package thread_study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock3 {

    Lock lock = new ReentrantLock();

    boolean locked1 = true;
    boolean locked2 = true;


    void m1() {
        try {
            //lock.lock();
            lock.lockInterruptibly();
            System.out.println("t1...");
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); // 这里无限睡
        }catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("中断异常=====>"+ e);
        }finally {
            if (locked1) lock.unlock();
        }
    }

    void m2() {
        try {
            lock.lock();
            //lock.tryLock();
            System.out.println("t2...");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked2) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 r = new ReentrantLock3();
        Thread t1 = new Thread(() -> r.m1());
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> r.m2());
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.locked1 = false;
        t1.interrupt();



    }

}
