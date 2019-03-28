package thread_study;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TArrayBlockingQueue2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10,true);
        ExecutorService service = Executors.newFixedThreadPool(500);
        List<Future<Boolean>> list = new ArrayList<>();


        for (int i=0;i<1000;i++) {

            Future<Boolean> f = service.submit(() -> {
                //System.out.println("adding.....");
                return queue.offer("a");
            });
            list.add(f);

        }
        //System.out.println(service);
        System.out.println(list.size());
        Future<Boolean> ff = list.get(300);
        System.out.println(ff.get());

        //System.out.println(queue.size());
    }
}
