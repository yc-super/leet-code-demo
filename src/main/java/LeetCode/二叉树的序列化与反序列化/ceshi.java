package LeetCode.二叉树的序列化与反序列化;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ceshi {
    public static void main(String[] args) {
        Deque<Integer> deque=new LinkedList<>();
//        Stack<Integer> deque=new Stack<>();
        deque.offer(1);
        deque.offer(2);
        Integer pop = deque.poll();
        Integer pop1 = deque.poll();
        System.out.println();
    }
}
