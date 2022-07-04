package LeetCode_Hot100.LRU缓存;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {

    }
    //思路：一维数组刻画 最近最少使用的数据，哈希表O(1)复杂度取数据
    /*
    *
    * [1,2,3]
    * 1
    * 1
    * */
    private int capacity;
    //越靠后，越是最近使用过的
    private LinkedList<Integer> array;
    private Map<Integer,Integer> map1;//存储k-v对
    public LRUCache(int capacity) {
        this.capacity=capacity;
        array=new LinkedList<>();
        map1=new HashMap<>();
    }

    public int get(int key) {
        if(map1.containsKey(key)){
            //更新优先级
            array.remove(new Integer(key));
            array.addFirst(key);

            return map1.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        //先判断哈希表中是否有该key
        if(map1.containsKey(key)){
            //包含该key,将value替换即可
            map1.put(key,value);

            //此处要不要更新该key的优先级
            array.remove(new Integer(key));
            array.addFirst(key);

        }else{
            //不包含该key，需要添加k-v对，先检查容量是否已满
            if(map1.size()==capacity){
                //容量已满，删除最近最少使用的元素
                map1.remove(array.getLast());
                map1.put(key,value);
                array.removeLast();
                array.addFirst(key);
            }else{
                //容量未满，直接添加
                map1.put(key,value);
                array.addFirst(key);
            }
        }
    }
}
