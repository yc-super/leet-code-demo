package 测试;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Slf4j
public class ceshi6 {
    public static void main(String[] args) {
        /*List<String> list=new ArrayList();
        list.add("1");
        Object[] objects = list.toArray();//直接用list.toArray()，只能得到Object类型的数组
        String[] array = list.toArray(new String[0]);//将list转化为Stirng数组*/

        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            try {
                System.out.println(2/0);
                int a=3/0;
            }catch (Exception e){
                log.error("异常信息：{}{}",e);
            }
        }
    }
}
