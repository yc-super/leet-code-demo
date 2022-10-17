package 代码随想录.二叉树.前中后序遍历.N叉树的后序遍历;

import java.util.*;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result=new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            Node node = deque.pop();
            result.add(node.val);

            if(node.children!=null){
                for (int i = 0; i <node.children.size(); i++) {
                    deque.push(node.children.get(i));
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
