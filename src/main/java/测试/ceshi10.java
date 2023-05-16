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
        String ss="{\"name\":\"yc\",\"age\":\"12\"}";
        String s = JSON.toJSONString(ss);
//        Map<String,Object> map=JSONObject.parseObject(JSON.toJSONString(ss));
        Map<String,Object> map=(Map)JSON.parse(ss);
       /* Integer n,data,sum;//n表示循环变量，data表示输入的一个整数，sum表示部分和
        // sum = 0;
        if(sum==0)
        Scanner sc = new Scanner(System.in);
        for(n = 0;n<5;n++){
            data = sc.nextInt();
            sum =sum + data;
        }
        System.out.println(sum/5);*/
        System.out.println(name);

//        a++;
    }
}
