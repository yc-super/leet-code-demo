package 测试;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ceshi6 {
    public static void main(String[] args) {
        List<String> list=new ArrayList();
        list.add("1");
        Object[] objects = list.toArray();//直接用list.toArray()，只能得到Object类型的数组
        String[] array = list.toArray(new String[0]);//将list转化为Stirng数组
    }
}
