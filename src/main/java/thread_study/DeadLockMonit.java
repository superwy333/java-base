package thread_study;


import java.util.concurrent.TimeUnit;

/**
 * 死锁模拟
 * 一个对象有两个同步方法m1 m2
 * m1中需要调用m2,m2中需要两用m1
 * 两个线程，一个调用m1,一个调用m2
 */
public class DeadLockMonit {

    public synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(2); // 这边睡2秒，是模拟其他的业务代码执行过程
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println(Thread.currentThread().getName() + " m1 end... ");
    }

    public synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2); // 这边睡2秒，是模拟其他的业务代码执行过程
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        m1();
        System.out.println(Thread.currentThread().getName() + " m2 end... ");
    }

    public static void main(String[] args) {
        DeadLockMonit d = new DeadLockMonit();
        new Thread(() -> d.m1()).start();
        new Thread(() -> d.m2()).start();
    }
    
}
