package thread_study;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2019/3/18.
 */
public class TicketSeller2 {

    static Queue<String> list = new ConcurrentLinkedQueue<>();

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
                    String ticket = list.poll(); // 这个方法并没有同步锁啊，怎么实现并发？？？
                    if (ticket==null) break;
                    System.out.println("卖出去了 "+ticket);
                }
            }).start();
        }
    }
}
