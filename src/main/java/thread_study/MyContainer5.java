package thread_study;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangyang on 2019/3/12.
 */
public class MyContainer5<T> {

    private static final int MAX_VALUE = 10;

    private final LinkedList<T> list = new LinkedList<>();

    Lock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();


    public void put(T t) {

        lock.lock();
        while (list.size()==10) { // 这里使用while是为了让线程被唤醒之后再做一次检查
            System.out.println("生产者等待 "+Thread.currentThread().getName());
            try {
                producer.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        //count++;
        System.out.println("当前size为: " + list.size());
        //notifyAll(); // 唤醒其它等待中的线程
        consumer.signalAll();
    }

    public T get() {

        lock.lock();
        while (list.size()==0) {
            System.out.println("消费者等待 "+Thread.currentThread().getName());
            try {
                consumer.await();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.removeFirst(); //取第一个
        //count--;
        //notifyAll(); // 唤醒其它等待中的线程
        producer.signalAll();
        return t;
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
