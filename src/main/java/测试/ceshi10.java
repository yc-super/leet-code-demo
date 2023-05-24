package 测试;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ceshi10 {
    private static String name;
    public static void main(String[] args)
    {
       List<String> list=new ArrayList<>();
       list.add("架空ff");
       list.add("ff");
       list.add("1架空ff");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if(next.indexOf("架空")==-1){
                iterator.remove();
            }
        }
        System.out.println(list.toArray());
    }
}
