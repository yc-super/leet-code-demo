package 代码随想录.二叉树.层序遍历.填充每个节点的下一个右侧节点指针;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 1) {
                Node poll = queue.poll();
                poll.next = queue.peek();
                if (poll.left != null)
                    queue.add(poll.left);
                if (poll.right != null)
                    queue.add(poll.right);
            }
            Node poll = queue.poll();
            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }
        return root;
    }

}

