package thread_study;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @description:
 * @author: Wy
 * @create: 2019-03-27 12:47
 **/
public class TForkJoinPool {

    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000; // 子任务的计算量最大是50000的数字
    static Random r = new Random();

    static {
        for (int i=0;i<nums.length;i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum()); // 使用steam api 进行计算数组所有元素的总和
    }

    /*static class Addtask extends RecursiveAction { // 没有返回值，没法做最后的join

        int s,e;

        Addtask(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        protected void compute() {
            long sum = 0L;
            if (e - s < MAX_NUM) { // 如果本次任务中计算的范围小于一个任务最大计算值，则直接计算结果
                for (int i=s;i<e;i++) sum += nums[i];
                System.out.println("from " + s + " to " + e + " total is: " + sum);
            }else { // 否则把任务继续分成子任务
                int middle = s + (e-s)/2; // 取中间

                Addtask subTask1 = new Addtask(s, middle);
                Addtask subTask2 = new Addtask(middle, e);
                // fork()方法调用重写的compute()方法，如果单个子任务的范围还是太大的话，会在第二次执行的compute方法里面再次拆分
                subTask1.fork();
                subTask2.fork();
            }
        }
    }*/

    static class Addtask extends RecursiveTask<Long> { // 没有返回值，没法做最后的join

        int s,e;

        Addtask(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        protected Long compute() {
            long sum = 0L;
            if (e - s < MAX_NUM) { // 如果本次任务中计算的范围小于一个任务最大计算值，则直接计算结果
                for (int i=s;i<e;i++) sum += nums[i];
                System.out.println("from " + s + " to " + e + " total is: " + sum);
                return sum;
            }else { // 否则把任务继续分成子任务
                int middle = s + (e-s)/2; // 取中间

                Addtask subTask1 = new Addtask(s, middle);
                Addtask subTask2 = new Addtask(middle, e);
                // fork()方法调用重写的compute()方法，如果单个子任务的范围还是太大的话，会在第二次执行的compute方法里面再次拆分
                subTask1.fork();
                subTask2.fork();

                return subTask1.join() + subTask2.join();
            }
        }
    }



    public static void main(String[] args) throws IOException{
        //TForkJoinPool t = new TForkJoinPool();
        Addtask task = new Addtask(0,nums.length);
        ForkJoinPool f = new ForkJoinPool();
        f.execute(task); // 守护线程
        Long sum = task.join(); // join()本身就是阻塞的，所以下面不需要阻塞
        System.out.println(sum);
        //System.in.read(); // 这个也是阻塞主线程

    }

}
