package thread_study;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by wangyang on 2019/3/19.
 */
public class TConcurrentLinkedQueue {

    public static void main(String[] args) {

        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for(int i=0;i<10;i++) {
            strs.offer("a"+i); // offer类似于add，add会抛异常，offer不会，而是以boolean类型返回值替代
        }

        System.out.println(strs);
        System.out.println(strs.size());

        System.out.println(strs.poll()); // 取出第一个加进去的，这个元素取出来之后就没有了
        System.out.println(strs.size());

        System.out.println(strs.peek()); // 读取第一个加进去的元素，不改变数据集合
        System.out.println(strs.size());
    }
}
