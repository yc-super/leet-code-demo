package 宫水三叶.BFS.填充每个节点的下一个右侧节点指针II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // 我的题解，层序遍历，通过count1记录当前层个数，count2记录下一层个数，当count1耗尽时，next指向null而非poll出的元素
    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count1 = 1, count2 = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count1--;
            if (count1 == 0) {
                node.next = null;
            } else {
                node.next = queue.peek();
            }

            if (node.left != null) {
                queue.offer(node.left);
                count2++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                count2++;
            }
            if (count1 == 0) {
                count1 = count2;
                count2 = 0;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
