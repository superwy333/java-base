package thread_study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer2 {

    // volatile使得MyContainer2类对象的list属性对所有线程都可见
    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer2 c= new MyContainer2();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 start....");
                if (c.size()!=5) {
                    try {
                        lock.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end....");
                lock.notify(); // 通知t1继续执行

            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 start....");
                for (int i=0;i<10;i++) {
                    c.add(new Object());
                    System.out.println(Thread.currentThread().getName() + " add " + i);
                    if (c.size()==5) {
                        lock.notify(); // notify()不会释放锁，所以即使这边唤醒了t1，也要等到t2结束了t1才能接着往下走
                        try {
                            lock.wait(); // 所以这边得先wait()，使t2释放锁
                        }catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();
    }
}
