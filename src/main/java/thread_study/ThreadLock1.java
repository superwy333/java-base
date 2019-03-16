package thread_study;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2019/3/12.
 */
public class ThreadLock1 {

    volatile static Person p = new Person();

    public static void main(String[] args) {

        ThreadLock1 t = new ThreadLock1();

        new Thread(()-> {
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }
}

class Person {
    String name = "zhangsan";
}
