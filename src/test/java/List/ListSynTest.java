package List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class ListSynTest {

    //private static  List<Integer> list = new ArrayList<Integer>();

    //private static  List<String> list = new ArrayList<String>();

    private static Vector<String> list = new Vector<String>();

    /**
     * 验证ArrayList是非同步的（非线程安全的）
     */
    @Test
    public void test() {
        try {
            /*list.add(1);
            list.add(2);
            list.add(3);*/
            new ThreadOne().start();
            new ThreadTwo().start();




        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*private static class ThreadOne extends Thread {
        @Override
        public void run() {
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
    }

    private static class ThreadTwo extends Thread {
        @Override
        public void run() {
            for (int i=4;i<6;i++) {
                list.add(i);
                System.out.println("---ThreadOne---end>>>>" + list.toString());
                try {
                    //sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }*/



    private static void printAll() {
        System.out.println("");

        String value = null;
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
    }

    /**
     * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadOne extends Thread {
        public void run() {
            int i = 0;
            while (i<6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    /**
     * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadTwo extends Thread {
        public void run() {
            int i = 10;
            while (i<16) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }
}
