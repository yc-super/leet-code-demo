package 代码随想录.二叉树.前中后序遍历.N叉树的前序遍历;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //迭代
    public List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> deque=new LinkedList<>();
        deque.push(root);
        int children_num;
        while(!deque.isEmpty()){
            Node node = deque.pop();
            result.add(node.val);

            if(node.children!=null){
                children_num=node.children.size();
                for (int i = children_num-1; i >=0; i--) {
                    deque.push(node.children.get(i));
                }
            }
        }
        return result;
    }
    //递归
    public List<Integer> preorder2(Node root) {
        List<Integer> result=new ArrayList<>();
        preorder3(root,result);
        return result;
    }

    private void preorder3(Node root, List<Integer> result) {
        if(root==null)
            return;
        result.add(root.val);
        int size=root.children.size();
        for (int i = 0; i <size; i++) {
            preorder3(root.children.get(i),result);
        }
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
