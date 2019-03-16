package thread_study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个固定容量的阻塞式同步容器
 * 支持put()，get()，size()方法
 * 使用生产者消费者模式，支持2个生产者和10个消费者
 * Created by wangyang on 2019/3/11.
 */
public class MyContainer4<T> {


    private static final int MAX_VALUE = 10;

    //private final List<T> list = new ArrayList<>(MAX_VALUE);

    //private final Vector<T> list = new Vector<>(); // 这边使用Vector是想要试图为了使size()方法更准确

    private final LinkedList<T> list = new LinkedList<>();

    //private int count = 0;

    public synchronized void put(T t) {

        while (list.size()==10) { // 这里使用while是为了让线程被唤醒之后再做一次检查
            System.out.println("生产者等待 "+Thread.currentThread().getName());
            try {
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        //count++;
        System.out.println("当前size为: " + list.size());
        notifyAll(); // 唤醒其它等待中的线程

    }

    public synchronized T get(/*int index*/) {

        while (list.size()==0) {
            System.out.println("消费者等待 "+Thread.currentThread().getName());
            try {
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.removeFirst(); //取第一个
        //count--;
        notifyAll(); // 唤醒其它等待中的线程
        return t;
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer4<Object> m = new MyContainer4<>();

        for (int i=0;i<10;i++) { // 启动10个消费者
            new Thread(() -> {
                while (true) {
                    System.out.println(m.get());
                }

            },"c"+i).start();
        }

        for (int i=0;i<2;i++) {
            new Thread(() -> {
                while (true) {
                    m.put(new Object());
                }
            },"p"+i).start();
        }
    }

}
