package List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    @Test
    public void test1() {
        List<String> stringList = new ArrayList<String>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        stringList.add("aaa");
        System.out.println(stringList);
    }

    @Test
    public void test2() {
        List<String> stringLinkedListList = new LinkedList<String>();
        stringLinkedListList.add("aaa");
        stringLinkedListList.add("bbb");
        stringLinkedListList.add("ccc");
        stringLinkedListList.add("aaa");
        System.out.println(stringLinkedListList);
    }





}
