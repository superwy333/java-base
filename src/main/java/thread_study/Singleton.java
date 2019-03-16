package thread_study;

/**
 * Created by wangyang on 2019/3/12.
 */
public class Singleton {


    private Singleton() { // 私有化构造器，防止外部对象创建

    }

    private static class Inner { // 创建一个私有的内部类，其它对象无法访问，内部类中直接new一个静态的Singleton

        private static Singleton s = new Singleton();

    }

    public static Singleton getSingleton() { // 返回内部类中的静态Singleton对象
        return Inner.s;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            new Thread(() -> {
                System.out.println(getSingleton() + " " + Thread.currentThread().getName());

            },"t"+i).start();
        }
    }
}
