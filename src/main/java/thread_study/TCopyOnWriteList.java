package thread_study;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wangyang on 2019/3/18.
 */
public class TCopyOnWriteList {

    public static void main(String[] args) {

        Random r = new Random();

        // List<String> list = new ArrayList<>();
        // Vector<String> list = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();

        Thread[] ths = new Thread[100];

        for (int i=0;i<ths.length;i++) {
            ths[i] = new Thread(() -> {
                for (int j=0;j<100;j++) {
                    list.add("a"+r.nextInt(100000));
                }
            });
        }
        calTime(ths);
        System.out.println(list.size());
    }

    static void calTime(Thread[] ths) {
        long start = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t -> t.start());
        Arrays.asList(ths).forEach(t -> {
            try {
                t.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
