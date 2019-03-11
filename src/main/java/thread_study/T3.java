package thread_study;

public class T3 {


    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start... ");
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end... ");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        T3 t = new T3();
        new Thread(() ->t.m1(),"t1").start(); //lambda表达式写法，相当于new Runnable然后在run()方法中执行t.m1()
        new Thread(() ->t.m2(),"t2").start();
    }

}
