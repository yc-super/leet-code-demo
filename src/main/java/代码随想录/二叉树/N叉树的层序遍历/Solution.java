package 代码随想录.二叉树.N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        int len;
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            len=queue.size();
            while(len>0){
                Node node = queue.poll();
                list.add(node.val);

                if(node.children!=null&&node.children.size()>0){
                    for(Node n:node.children){
                        if(n!=null)
                            queue.offer(n);
                    }
                }

                len--;
            }
            result.add(list);
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
