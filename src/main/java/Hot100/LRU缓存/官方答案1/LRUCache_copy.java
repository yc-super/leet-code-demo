package Hot100.LRU缓存.官方答案1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_copy {
    class LinkNode{
        int key;
        int value;
        LinkNode pre;
        LinkNode next;
        public LinkNode(){}
        public LinkNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private int size;
    private LinkNode head,tail;
    Map<Integer,LinkNode> map;


    public LRUCache_copy(int capacity){
        this.capacity=capacity;
        head=new LinkNode();
        tail=new LinkNode();
        head.next=tail;
        tail.pre=head;
        size=0;
        map=new HashMap<>();
    }

    public int get(int key) {
        LinkNode node=map.get(key);
        if(node==null)
            return -1;
        removeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkNode node=map.get(key);
        if(node==null){
            //新增
            LinkNode linkNode = new LinkNode(key,value);
            map.put(key,linkNode);
            addToHead(linkNode);
            size++;
            if(size>capacity){
                LinkNode pre = removeTail();
                map.remove(pre.key);
                size--;
            }
        }else{
            //更新
            node.value=value;
            removeToHead(node);
        }
    }

    private LinkNode removeTail() {
        LinkNode pre = tail.pre;
        remove(pre);
        return pre;
    }

    private void addToHead(LinkNode node) {
        node.pre=head;
        node.next=head.next;
        head.next=node;
        node.next.pre=node;
    }

    private void remove(LinkNode node) {
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void removeToHead(LinkNode node) {
        remove(node);
        addToHead(node);
    }

}
