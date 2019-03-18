package thread_study;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangyang on 2019/3/12.
 */
public class TicketSeller1 {

    //static List<String> list = new ArrayList<>();
    static Vector<String> list = new Vector<>(); // 这里需要使用同步容器，不然非同步的容器会出现返回空指针的情况

    static Lock lock = new ReentrantLock();

    static { // 初始化车票
        for (int i=0;i<1000;i++) {
            list.add("车票编号"+ i);
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            new Thread(() -> {
                while (list.size()>0) {
                    // 就算使用线程同步的Vector容器，
                    // 高并发在这里还是会出现一个线程走进这个判断了，但是别的线程把票买走了
                    // 这里设置了一个10毫秒的延迟来放大这种场景出现的概率
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("卖出去了 "+list.remove(0));
                }
            }).start();
        }
    }

    /*public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            new Thread(() -> {
                synchronized (TicketSeller1.class) {
                    while (list.size()>0) {
                        System.out.println("卖出去了 "+list.remove(0));
                    }
                }
            }).start();
        }
    }*/

    /*public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    while (list.size()>0) {
                        System.out.println("卖出去了 "+list.remove(0));
                    }
                }finally {
                    lock.unlock();
                }
            }).start();
        }
    }*/
}
