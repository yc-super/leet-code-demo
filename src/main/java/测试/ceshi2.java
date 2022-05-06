package 测试;

import java.math.BigDecimal;
import java.util.*;

public class ceshi2 {
    public static void main(String[] args) {
        Integer[] in={1,2,3};
        final List<Integer> list = Arrays.asList(in);
        System.out.println(list);
        in[2]=10;
        System.out.println(list);
//        list.add(222);//asList生成的list不能使用add和remove方法，会报错
//        list.remove(2);
    }
}
