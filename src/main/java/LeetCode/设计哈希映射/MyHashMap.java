package LeetCode.设计哈希映射;

class MyHashMap {

    // 简单的利用数组，缺点是空间占用太大
    private int[] temp;

    public MyHashMap() {
        temp = new int[1000001];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=-1;
        }
    }

    public void put(int key, int value) {
        temp[key] = value;
    }

    public int get(int key) {
        return temp[key];
    }

    public void remove(int key) {
        temp[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
