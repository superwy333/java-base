package thread_study;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TTransferQueue {

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> queue = new LinkedTransferQueue<>();

        new Thread(() -> { // 先启动消费者线程，再往里面transfer元素的时候，不会阻塞
            try {
                System.out.println(queue.take());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        queue.transfer("aaa");

        /*new Thread(() -> { // 后启动消费者线程的情况下，上面的queue.transfer("aaa")会阻塞
            try {
                System.out.println(queue.take());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }
}
