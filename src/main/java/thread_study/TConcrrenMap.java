package thread_study;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2019/3/18.
 */
public class TConcrrenMap {


    public static void main(String[] args) {

        Random r = new Random();

        Map<String,String> map = new ConcurrentHashMap<>();

        //Map<String,String> map = new ConcurrentSkipListMap<>();

        /*Map<String,String> map = new HashMap<>();
        Collections.synchronizedMap(map);*/

        Thread[] ths = new Thread[100]; // 100个线程

        CountDownLatch latch = new CountDownLatch(ths.length); // 使用线程数组的数量作为门闩的锁

        long start = System.currentTimeMillis();

        for (int i=0;i<ths.length;i++) { // 定义线程方法
            ths[i] = new Thread(() -> {
                for (int j=0;j<10000;j++) {
                    map.put("a"+r.nextInt(100000),"a"+r.nextInt(100000));
                }
                latch.countDown(); // 每个线程执行完之后都要把门闩的锁减去1
            });
        }

        Arrays.asList(ths).forEach(t -> t.start()); // 启动所有线程

        try {
            latch.await(); // 主线程在这里等待
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

}
