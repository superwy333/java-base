package thread_study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangyang on 2019/3/9.
 */
public class ReentrantLock2 {

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
        //boolean locked = lock.tryLock();
        boolean locked = false; // 没有拿到锁
        try {
            //lock.lock();
            locked = lock.tryLock(20,TimeUnit.SECONDS);
            if (locked) { // 拿到锁之后做的行为
                System.out.println("m2 with lock..." + locked);
            }else { // 等待了5秒如果还没有拿到锁之后做的行为
                System.out.println("m2 without lock..." + locked);
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock2 r = new ReentrantLock2();
        new Thread(() -> r.m1()).start();
        new Thread(() -> r.m2()).start();
    }
}
