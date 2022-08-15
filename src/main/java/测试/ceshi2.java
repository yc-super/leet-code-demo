package 测试;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class ceshi2 {
    public static void main(String[] args) {
       /*Map<String,Double> map=new HashMap();
       map.put("x",1.11);
       map.put("y",2.22);
       Map<String,Double> map2=new HashMap();
       map2.put("x",3.33);
       map2.put("y",4.44);
       List<Map<String,Double>> list=new ArrayList<>();
       list.add(map);
       list.add(map2);

       Map<String,Object> mm=new HashMap<>();
       mm.put("cc",list);

        List<Map<String,Double>> cc = (List<Map<String,Double>>)mm.get("cc");
        for(Map<String,Double> map1:cc){
            System.out.println(map1.get("x"));
            System.out.println(map1.get("y"));
            System.out.println();
        }*/

        methodA();
    }

    private static void methodA() {
        try {
            System.out.println("A方法");
            methodB();
        }catch (Exception e){
            System.out.println("触发");
//            e.printStackTrace();
        }
    }

    private static void methodB() {
        System.out.println("B方法");
        methodC();
    }

    private static void methodC() {
        System.out.println("C方法");
        int i = 3 / 0;
        System.out.println(11);
    }
}
