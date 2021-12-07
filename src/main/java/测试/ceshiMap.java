package 测试;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ceshiMap {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);

        //方式1，entrySet遍历，在键和值都需要时使用（最常用）
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }

        //2.通过keySet或values来实现遍历，性能略低于第一种方式
        System.out.print("key:");
        for(Integer key:map.keySet()){
            System.out.print(key+",");
        }
        System.out.println();
        System.out.print("value:");
        for(Integer vlaue:map.values()){
            System.out.print(vlaue+",");
        }
        System.out.println();

        //方式3,Iterator遍历
        Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=it.next();
            if((int)entry.getKey()==1){//此处把key为1的键值对移除，因此方式3和4的遍历结果中没有key为1，value为2的键值对
                it.remove();//如果想要在遍历时移除键值对，就用Iterator这种方式
                continue;
            }
            System.out.println("key:"+entry.getKey()+",vlaue:"+entry.getValue());
        }

        //方式4，java8，lambda
        //java8提供了lambda表达式，语法更简洁，可以同时拿到key和value
        //不过，经测试，性能没有entrySet好
        map.forEach((key,value)->{
            System.out.println("key:"+key+",vlaue:"+value);
        });
    }
}
