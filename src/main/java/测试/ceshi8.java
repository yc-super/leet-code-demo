package 测试;

import java.util.ArrayList;
import java.util.List;

public class ceshi8 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(3));
        list.add(new Integer(5));

        System.out.println(list);

        Integer integer = list.get(2);

        list.remove(integer);

        System.out.println(list);

    }
}
