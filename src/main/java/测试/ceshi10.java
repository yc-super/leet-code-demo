package 测试;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ceshi10 {
    private static String name;
    public static void main(String[] args) throws ParseException {
//        String dateStr="2023-08-29 09:31:02";
//        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = format.parse(dateStr);
//        long time = date.getTime();
//        System.out.println(time);
//
//        long ss=8306727399999l;
//        Date date1=new Date(ss*1000);
//        String format1 = format.format(date1);
//        System.out.println(format1);

        Integer[] aa={3,4,5,6};
        Integer[] integers = Arrays.copyOfRange(aa, 0, aa.length-2);
        Integer[] integers1 = Arrays.copyOf(aa, aa.length - 2);
        System.out.println();
        Arrays.fill(aa,33);
        System.out.println();
    }
};
