package 大厂算法题2025.二叉搜索树中最接近的k个值;

import com.alibaba.fastjson.JSON;
import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

import java.util.*;

// 考察树的基本知识、PriorityQueue、对二叉搜索树有序性的利用
// 有3个思路：小顶堆、大顶堆、二分法。其中前两种比较好想，但是都没有或者没能完全利用到二叉搜索树的性质

// 题目描述：https://blog.csdn.net/zhizhengguan/article/details/116591967
// 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。
public class Solution {
    public static void main(String[] args) {
        Integer[] array = {4, 2, 5, 1, 3};
        TreeNode treeNode = TreeNodeUtils.getTreeNode(array);
        List<Integer> method = new Solution().method3(treeNode, 2, 3);
        System.out.println(JSON.toJSONString(method));
    }

    // 最小堆，遍历放入最小堆，之后取出k个值
    public List<Integer> method(TreeNode root, int target, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1 - target);
                int b = Math.abs(o2 - target);
                return a - b;
            }
        });

        // 中序遍历二叉树，将k个元素加入到queue中
        track(root, queue);

        // 将元素存入list中
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = queue.iterator();
        for (int i = 0; i < k; i++) {
            list.add(iterator.next());
        }

        return list;
    }

    private void track(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null)
            return;
        track(root.left, queue);

        queue.add(root.val);

        track(root.right, queue);
    }

    // 最大堆，遍历过程中，如果queue满了则弹出堆顶最大的，存入一个更小的
    public List<Integer> method2(TreeNode root, int target, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1 - target);
                int b = Math.abs(o2 - target);
                return b - a;
            }
        });

        // 中序遍历二叉树，将k个元素加入到queue中
        track2(root, queue, k);

        // 将元素存入list中
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = queue.iterator();
        for (int i = 0; i < k; i++) {
            list.add(iterator.next());
        }

        return list;
    }

    private void track2(TreeNode root, PriorityQueue<Integer> queue, int k) {
        if (root == null)
            return;
        track2(root.left, queue, k);

        queue.add(root.val);
        if (queue.size() == k + 1) {
            queue.poll();
        }

        track2(root.right, queue, k);
    }

    // 二分法。在中序遍历过程中直接比较
    // 当遍历到一个节点时，如果此时结果数组不到k个，直接将此节点值加入结果 res 中
    //如果该节点值和目标值的差值的绝对值小于结果 res 的首元素和目标值差值的绝对值，
    // 说明当前值更靠近目标值，则将首元素删除，末尾加上当前节点值，
    // 反之的话说明当前值比结果 res 中所有的值都更偏离目标值，由于中序遍历的特性，
    // 之后的值会更加的偏离，所以此时直接返回最终结果即可
    public List<Integer> method3(TreeNode root, int target, int k) {
        // 先将二叉搜索树中的元素存入一个集合
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        track3(root, deque, target, k);

        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    private void track3(TreeNode root, Deque<Integer> deque, int target, int k) {
        if (root == null)
            return;
        track3(root.left, deque, target, k);

        if (deque.size() != k) {
            deque.offer(root.val);
        } else {
            if (Math.abs(deque.peek() - target) > Math.abs(root.val - target)) {
                deque.pop();
                deque.offer(root.val);
            } else {
                return;
            }
        }

        track3(root.right, deque, target, k);
    }
}
