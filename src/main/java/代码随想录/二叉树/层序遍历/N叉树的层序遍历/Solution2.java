package 代码随想录.二叉树.层序遍历.N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size != 0) {
                Node n = queue.poll();
                list.add(n.val);
                if (n.children != null) {
                    for (Node node : n.children) {
                        queue.add(node);
                    }
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }
}

