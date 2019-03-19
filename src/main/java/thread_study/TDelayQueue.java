package thread_study;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2019/3/19.
 */
public class TDelayQueue {

    static BlockingQueue<MyTask> tasks = new DelayQueue<>();


    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        //System.out.println(now);
        MyTask myTask1 = new MyTask(now + 1000);
        MyTask myTask2 = new MyTask(now + 500);
        MyTask myTask3 = new MyTask(now + 1500);
        tasks.put(myTask1);
        tasks.put(myTask2);
        tasks.put(myTask3);
        System.out.println(tasks);
        for (int i=0;i<3;i++) {
            System.out.println(tasks.take()); // 取出的时候会按照compareTo()定义的顺序来取出
        }
    }

    static class MyTask implements Delayed {

        long runningTime;

        MyTask(long rt) {
            this.runningTime = rt;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            //return this.runningTime;
            return unit.convert(runningTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) { // 通过这个方法，来定义DelayQueue里面元素的排序方式
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "" + runningTime;
        }
    }
}
