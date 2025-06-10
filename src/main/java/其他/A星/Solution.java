package 其他.A星;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
 * A*算法，array代表棋盘，值为0代表可走的路径，值为2代表起始点，值为3代表终点，值为4代表障碍物
 * one代表起始点坐标，长度为2
 * target代表终点坐标，长度为2
 * 假设某个点的右侧有障碍物，那么无法跨过障碍物到达该点右下角
 * openList，用array中设置为5来代替，closeList，用array中设置为6来代替
 * */
public class Solution {

    public static void main(String[] args) {
        int[][] array={
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
        System.out.println(new Solution().AA(array,new int[]{12,8},new int[]{13,31}));
    }
    public List<int[]> AA(int[][] array, int[] one, int[] target) {
        List<Node> openList = new ArrayList<>();
//        List<Node> closeList = new ArrayList<>();// 将array中的值设置为6，代表加入了closeList
        Node n = new Node(0, getLength(target[0], target[1], one[0], one[1]), null, one[0], one[1]);
        openList.add(n);
        setOpen(array, one[0], one[1]);

        while (!openList.isEmpty()) {
            // 从openList中找到一个最小f值的node，加入close
            Node minNode = openList.get(0);
            for (int i = 0; i < openList.size(); i++) {
                Node node = openList.get(i);
                if (node.f < minNode.f) {
                    minNode = node;
                }
            }
            openList.remove(minNode);
            setClose(array, minNode.x, minNode.y);

            // 将该node周围的点加入open
            int r = addNode(array, minNode, one, target, openList);
            if (r == 1) {
                // 已经将终点加入了open，结束
                break;
            }
        }
        List<int[]> resultList = new ArrayList<>();

        Node nowNode=getNodeFromOpen(target[0],target[1],openList);
        while (nowNode!=null){
            int[] ints = {nowNode.x, nowNode.y};
            resultList.add(ints);
            nowNode = nowNode.parent;

            array[nowNode.x][nowNode.y]=8;
        }

        System.out.println(array);
        Objects.hash(1,2);
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.contains(2);
        return null;
    }

    private int getLength(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // 将8个节点尝试加入open，返回1代表已经将终点加入了open
    private int addNode(int[][] array, Node node, int[] one, int[] target, List<Node> openList) {
        int x = node.x;
        int y = node.y;
        int g = node.g;
        int h = node.h;
        // 尝试将左边节点加入open
        int aa = addToOpen(array, node, openList, one, target, 0, -1);
        // 如果加入openList的节点就是终点，则结束
        if (aa == 1)
            return 1;

        // 尝试将上边节点加入open
        int bb = addToOpen(array, node, openList, one, target, -1, 0);
        // 如果加入openList的节点就是终点，则结束
        if (bb == 1)
            return 1;

        // 尝试将右边节点加入open
        int cc = addToOpen(array, node, openList, one, target, 0, 1);
        // 如果加入openList的节点就是终点，则结束
        if (cc == 1)
            return 1;

        // 尝试将下边节点加入open
        int dd = addToOpen(array, node, openList, one, target, 1, 0);
        // 如果加入openList的节点就是终点，则结束
        if (dd == 1)
            return 1;

        // 在左边、上边节点不是障碍物的情况下，尝试将左上角加入open
        if (aa == 0 && bb == 0) {
            int ee = addToOpen(array, node, openList, one, target, -1, -1);
            // 如果加入openList的节点就是终点，则结束
            if (ee == 1)
                return 1;
        }
        // 在上边、右边节点不是障碍物的情况下，尝试将右上角加入open
        if (bb == 0 && cc == 0) {
            int ee = addToOpen(array, node, openList, one, target, -1, 1);
            if (ee == 1)
                return 1;
        }
        // 在右边、下边节点不是障碍物的情况下，尝试将右下角加入open
        if (cc == 0 && dd == 0) {
            int ee = addToOpen(array, node, openList, one, target, 1, 1);
            if (ee == 1)
                return 1;
        }
        // 在下边、左边节点不是障碍物的情况下，尝试将左下角加入open
        if (dd == 0 && aa == 0) {
            int ee = addToOpen(array, node, openList, one, target, 1, -1);
            if (ee == 1)
                return 1;
        }
        return 0;
    }

    // 返回0代表成功加入（新加入或者之前就已经加入了），1代表将终点加入open，-1代表不符合要求（下标越界，或者为障碍物）
    private int addToOpen(int[][] array, Node node, List<Node> openList, int[] one, int[] target, int newX, int newY) {
        int x = node.x;
        int y = node.y;
        int g = node.g;
        int h = node.h;

        newX += x;
        newY += y;

        if (newX < 0 || newX >= array.length || newY < 0 || newY >= array[0].length || array[newX][newY] == 4|| array[newX][newY] == 6) {
            return -1;
        }

        if (newX == target[0] && newY == target[1])
            return 1;


        // 如果左边节点已经加入了open，则判断由当前节点到达左边节点是否会有更小的f值，如果是，则更新左边节点
        if (array[newX][newY] == 5) {
            Node nodeFromOpen = getNodeFromOpen(newX, newY, openList);
            int initF = nodeFromOpen.f;
            int initG = nodeFromOpen.g;
            int initH = nodeFromOpen.h;

            int nowG = g + 10;
            if (nowG < initG) {
                // 更新
                nodeFromOpen.g = nowG;
                nodeFromOpen.f = nodeFromOpen.g + nodeFromOpen.h;
                nodeFromOpen.parent = node;
            } else {
                // 什么都不做
            }
        } else {
            // 如果还没有加入open，则直接加入open
            int gg = getLength(newX, one[0], newY, one[1]);
            int hh = getLength(newX, target[0], newY, target[1]);
            openList.add(new Node(gg, hh, node, newX, newY));
            setOpen(array, newX, newY);
        }
        return 0;
    }

    private Node getNodeFromOpen(int i, int y, List<Node> openList) {
        for (Node node : openList) {
            if (node.x == i && node.y == y) {
                return node;
            }
        }
        return null;
    }

    private void setClose(int[][] array, int i, int j) {
        array[i][j] = 6;
    }

    private void setOpen(int[][] array, int i, int j) {
        array[i][j] = 5;
    }

    class Node {
        int g;
        int h;
        int f;
        Node parent;
        int x;
        int y;

        public Node(int g, int h, Node parent, int x, int y) {
            this.g = g;
            this.h = h;
            this.f = g + h;
            this.parent = parent;
            this.x = x;
            this.y = y;
        }
    }
}
