package thread_study;

/**
 * Created by wangyang on 2019/4/2.
 */
public class TSynchronized {


    public synchronized void test1() {

    }


    public void test2() {
        /**
         * synchronized()里面放一个对象
         * 对象的生命周期代表锁的范围
         */
        synchronized (this) { // 必须要存在一个共享对象才存在加锁的价值

        }

    }

    public static void main(String[] args) {

        TSynchronized sd = new TSynchronized();

    }


}
