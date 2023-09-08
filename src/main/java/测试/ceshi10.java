package 测试;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ceshi10 {
    private static String name;

    public static void main(String[] args) throws ParseException {
        String ss = null;
        String s = String.valueOf(ss);
        String s1 = null + "";
        if (StringUtils.isEmpty(s)) {
            System.out.println(1);
        }
        if (StringUtils.isEmpty(s1)) {
            System.out.println(2);
        }
        String sss = null;
        String sss1 = "";
        if (sss.isEmpty()) {
            System.out.println(3);
        }
        if (sss1.isEmpty()) {
            System.out.println(4);
        }
        System.out.println();
    }
}
