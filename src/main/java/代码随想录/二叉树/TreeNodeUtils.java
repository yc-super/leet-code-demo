package 代码随想录.二叉树;
/*
 * 1
 * 23
 * 4567
 * 89
 *
 *
 *
 * 1
 * 2
 * 4
 * 8
 * 16
 * */
// 1-2,2-4,4-8,8-16
// 0-1,1-3,3-7,7-15

//1-2,3-6,6-10

//2  n   +2
public class TreeNodeUtils {
    public static TreeNode getTreeNode(Integer[] nodes) {
        if (nodes == null)
            return null;

        int len = nodes.length;

        TreeNode[] rootArray = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if (nodes[i] != null)
                rootArray[i] = new TreeNode(nodes[i]);
        }

        for (int i = 0; i < len; i++) {
            if (rootArray[i] != null) {
                if (i * 2 + 1 < len) {
                    rootArray[i].left = rootArray[i * 2 + 1];//5--9,2--5,1--3
                } else {
                    break;
                }
                if (i * 2 + 2 < len) {
                    rootArray[i].right = rootArray[i * 2 + 2];//5--10,2--6
                } else {
                    break;
                }
            }
        }

        return rootArray[0];
    }
}
