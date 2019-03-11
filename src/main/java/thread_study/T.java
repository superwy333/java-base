package thread_study;


/**
 *
 *
 *
 */

public class T {

    private int count = 10;
    //private Object o = new Object();



    public void m() {
        synchronized (this) { // 任何线程执行下面的代码，自己对象实例的锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

    public static void main(String[] args) {

        T t = new T();
        t.m();


    }



}
