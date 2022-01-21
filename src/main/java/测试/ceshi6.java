package 测试;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Slf4j
public class ceshi6 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer next = it.next();
            if(next==2) {
                it.remove();
            }
            System.out.println(next);
        }
        for(Integer i:list){
            System.out.print(i+",");
        }
    }
}
