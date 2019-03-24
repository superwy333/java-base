package thread_study;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 计算1-200000中有多少个质数
 * 质数（素数）：只能被1和它自己整除
 */
public class ParallelComputing {

    public static void main(String[] args) throws Exception {

        // 单线程执行
        long start = System.currentTimeMillis();
        List<Integer> resultSingle = getPrimer(1, 200000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("resultSingle: " + resultSingle.size());

        // 使用线程池执行
        List<Integer> resultDou = new ArrayList<>();
        final int cpuCoreNum = 8;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
        Mytask task1 = new Mytask(1, 25000);
        Mytask task2 = new Mytask(25001, 50000);
        Mytask task3 = new Mytask(50001, 75000);
        Mytask task4 = new Mytask(75001, 100000);
        Mytask task5 = new Mytask(100001, 125000);
        Mytask task6 = new Mytask(125001, 150000);
        Mytask task7 = new Mytask(150001, 175000);
        Mytask task8 = new Mytask(175001, 200000);


        Future<List<Integer>> f1 = service.submit(task1);
        Future<List<Integer>> f2 = service.submit(task2);
        Future<List<Integer>> f3 = service.submit(task3);
        Future<List<Integer>> f4 = service.submit(task4);
        Future<List<Integer>> f5 = service.submit(task5);
        Future<List<Integer>> f6 = service.submit(task6);
        Future<List<Integer>> f7 = service.submit(task7);
        Future<List<Integer>> f8 = service.submit(task8);

        long start2 = System.currentTimeMillis();
        List<Integer> result1 = f1.get();
        List<Integer> result2 = f2.get();
        List<Integer> result3 = f3.get();
        List<Integer> result4 = f4.get();
        List<Integer> result5 = f5.get();
        List<Integer> result6 = f6.get();
        List<Integer> result7 = f7.get();
        List<Integer> result8 = f8.get();
        resultDou.addAll(result1);
        resultDou.addAll(result2);
        resultDou.addAll(result3);
        resultDou.addAll(result4);
        resultDou.addAll(result5);
        resultDou.addAll(result6);
        resultDou.addAll(result7);
        resultDou.addAll(result8);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
        System.out.println("resultDou: " + resultDou.size());
    }

    static class Mytask implements Callable<List<Integer>> {

        int start;
        int end;

        Mytask(int start, int end) {
            this.start = start;
            this.end = end;

        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrimer(start, end);
        }
    }


    /**
     * 是否是素数
     * @param num
     * @return
     */
    static boolean isPrimer(int num) {
        for (int i=2;i<num;i++) { // 除了1之外，如果还存在可以整出num的数字，则num不是素数；不可能有比num还大的数字可以整除它！
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * 取出给定范围中的所有素数
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    static List<Integer> getPrimer(int start, int end) throws Exception {
        if (end < start) throw new Exception("end must bigger than start！");
        List<Integer> result = new ArrayList<>();
        for (int i=start;i<=end;i++) {
            if (isPrimer(i)) result.add(i);
        }
        return result;
    }

}
