package LeetCode.设计哈希映射;

import java.util.Iterator;
import java.util.LinkedList;

// 链地址法
class MyHashMap2 {
    public static void main(String[] args) {
        Object o = new String("abc");
        String cast = String.class.cast(o);
        System.out.println(cast);
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private LinkedList[] data;
    private int BASE = 769;

    public MyHashMap2() {
        data = new LinkedList[BASE];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList datum = data[hash];
        Iterator<Pair> iterator = datum.iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.key == key) {
                next.setValue(value);
                return;
            }
        }
        datum.addLast(new Pair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        LinkedList datum = data[hash];
        Iterator<Pair> iterator = datum.iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey() == key) {
                return next.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList datum = data[hash];
        Iterator<Pair> iterator = datum.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey() == key) {
                iterator.remove();
                return;
            }
        }
    }

    private int hash(int key) {
        return key % BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
