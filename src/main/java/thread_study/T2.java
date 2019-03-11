package thread_study;

public class T2 implements Runnable{

    private int count = 10;

    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void main(String[] args) {
        T2 t = new T2();
        for (int i=1;i<=5;i++) {
            new Thread(t,"Thread" + i).start();
        }
    }
}
