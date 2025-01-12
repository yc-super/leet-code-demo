package LeetCode_Hot100.随机链表的复制;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/*
* 用时击败5.73%，内存击败68.51%
* 有一种更好的办法，看题解中的王尼玛，两种方法都很好
* */
class Solution {
    public static void main(String[] args) {
        Node n1=new Node(7);
        Node n2=new Node(13);
        Node n3=new Node(11);
        Node n4=new Node(10);
        Node n5=new Node(1);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        n2.random=n1;
        n3.random=n5;
        n4.random=n3;
        n5.random=n1;

        Node node = new Solution().copyRandomList(n1);
        System.out.println();
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Integer> m1 = new HashMap<>();
        Map<Integer, Node> m2 = new HashMap<>();
        Node h2 = head;
        int index = 0;
        Node result = new Node(0);
        Node temp = result;
        Map<Integer,Node> m4=new HashMap<>();
        while (h2 != null) {
            m1.put(h2, index);
            m2.put(index, h2.random);
            temp.val = h2.val;
            m4.put(index,temp);
            if (h2.next != null) {
                temp.next = new Node(h2.next.val);
            }
            index++;
            temp = temp.next;
            h2=h2.next;
        }
        Map<Integer,Integer> m3=new HashMap<>();
        for (int i = 0; i < index; i++) {
            Integer integer = m1.get(m2.get(i));
            m3.put(i,integer);
        }
        temp = result;
        index = 0;
        while (temp != null) {
            temp.random = m4.get(m3.get(index++));
            temp = temp.next;
        }
        return result;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
