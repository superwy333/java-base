package thread_study;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock4 extends Thread {

    Lock lock = new ReentrantLock(true); // 参数为true为公平锁

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock4 r = new ReentrantLock4();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        // 下面两个线程同时启动，
        // 如果是公平锁，
        // 那么线程1刚执行完，这个时候两个线程再次竞争同一把锁，
        // 此时线程2等待的时间肯定比线程1长，所以肯定是线程2得到所
        t1.start();
        t2.start();
    }
}
