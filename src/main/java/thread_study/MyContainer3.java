package thread_study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyContainer3 {

    // volatile使得MyContainer2类对象的list属性对所有线程都可见
    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer3 c = new MyContainer3();

        CountDownLatch latch = new CountDownLatch(1); // 门闩，构造函数中的参数的锁的数量，等于0时门闩就打开了
        new Thread(() -> {
            System.out.println("t2 start...");
            if (c.size()!=5) {
                try {
                    latch.await(); // 等待，不需要锁定任何对象
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end...");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 start...");
            for (int i=0;i<10;i++) {
                c.add(new Object());
                System.out.println(Thread.currentThread().getName() + " add " + i);
                if (c.size()==5) latch.countDown(); // 使门闩的锁-1
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
