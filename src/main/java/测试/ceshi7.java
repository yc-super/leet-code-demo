package 测试;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ceshi7 {
    private static Random random=new Random();
    public static void main(String[] args) {
        /*String s="123";
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(s)).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);*/
       /* System.out.println("ss"+1+2);
        System.out.println(1+2+"ss");
        System.out.println("ss"+(1+2));*/
        /*String s="1;2;3;";
        String[] split = s.split(";");
        System.out.println(split.length);*/
//        System.out.println(random.nextInt(10));
       /* Map<String,String> map=new HashMap<>();
        map.put("1","11");
        map.put("2","22");
        Map<String,String> map2=new HashMap<>(map);
        for(Map.Entry<String,String> entry:map2.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/
        String s="133455";
        char[] chars = s.toCharArray();
        System.out.println("133455".equals(chars));
    }

}
