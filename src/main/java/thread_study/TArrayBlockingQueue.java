package thread_study;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2019/3/19.
 */
public class TArrayBlockingQueue {

    public static void main(String[] args) {

        ArrayBlockingQueue<String> strs = new ArrayBlockingQueue<>(10); // 有界队列，最多放10个

        for (int i=0;i<10;i++) {
            strs.add("a"+i);
        }

        //strs.add("aaa"); // 会抛出异常
        //strs.offer("aaa"); // 不会抛异常，但是加不进去
        try {
            //strs.put("aaa"); // 队列满了会堵塞
            strs.offer("aaa",1, TimeUnit.SECONDS); // 等待1秒再尝试插入
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(strs);
    }
}
