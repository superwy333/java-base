package thread_study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer {

    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer c = new MyContainer();
        new Thread(() ->{
            for (int i=0;i<10;i++) {
                c.add(new Object());
                System.out.println(Thread.currentThread().getName() + " add " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(() -> {
            while (true) {
                if (c.size()==5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        },"t2").start();
    }


}
