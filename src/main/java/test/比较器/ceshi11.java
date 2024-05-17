package test.比较器;

import java.util.ArrayList;
import java.util.List;

public class ceshi11 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10,10);
        System.out.println(list);
        list.add(1,1000);
        System.out.println(list);
    }
}
