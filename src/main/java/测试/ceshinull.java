package 测试;

import java.util.*;

public class ceshinull {
    public static void main(String[] args) {
        //List
        /*List<Object> arrayList = new ArrayList<>();
        testList(arrayList);

        List<Object> linkedList = new LinkedList<>();
        testList(linkedList);

        List<Object> vector = new Vector<>();
        testList(vector);*/

        //Set
        /*Set hashSet=new HashSet();
        testSet(hashSet);

        Set linkedHashSet=new LinkedHashSet();
        testSet(linkedHashSet);

        Set TreeSet=new TreeSet();
        testSet(TreeSet);*/

        //map
        /*Map hashMap=new HashMap<>();
        testMap(hashMap);*/
    }

    private static void testMap(Map map) {
        System.out.println("-------------------------");
        map.put(null,null);
        map.put(null,null);
        if(map==null){
            System.out.println("!!为null");
            return;
        }
        System.out.println(map.size());
        System.out.println(map.get(0));
    }

    public static void testList(List list){
        System.out.println("-------------------------");
        list.add(null);
        list.add(null);
        if(list==null){
            System.out.println("!!为null");
            return;
        }
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
    public static void testSet(Set set){
        System.out.println("-------------------------");
        set.add(null);
        set.add(null);
        if(set==null){
            System.out.println("!!为null");
            return;
        }
        System.out.println(set.size());
    }
}


