package 代码随想录.二叉树.层序遍历.填充每个节点的下一个右侧节点指针;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        int len;
        while(!queue.isEmpty()){
            len=queue.size();
            while(len>0){
                Node node = queue.poll();
                if(len>1){
                    node.next=queue.peek();
                }else{
                    node.next=null;
                }
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                len--;
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
