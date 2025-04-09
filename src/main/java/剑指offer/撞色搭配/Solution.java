package 剑指offer.撞色搭配;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] ints = new Solution().sockCollocation(new int[]{4, 5, 2, 6, 5, 6});
        System.out.println(2 ^ 4);
    }

    // 题解，利用异或、与运算的性质，位运算
    public int[] sockCollocation2(int[] sockets) {
        int n = 0;
        for (int s : sockets) {
            n ^= s;
        }
        int m = 1;
        while ((n & m) ==0) {
            m <<= 1;
        }
        int x = 0, y = 0;
        for (int s : sockets) {
            if ((s & m) == 0)
                x ^= s;
            else y ^= s;
        }
        return new int[]{x, y};
    }


    // 小顶堆，不过不满足O（1）的空间复杂度要求
    public int[] sockCollocation(int[] sockets) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < sockets.length; i++) {
            queue.add(sockets[i]);
        }
        boolean f = true;
        int pre = 0;
        int[] result = new int[2];
        result[1] = -1;
        int index = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (f) {
                pre = current;
                f = false;
                continue;
            }
            if (current != pre) {
                result[index++] = pre;
//                f = true;
            } else {
                f = true;
            }
            pre = current;
        }
        if (result[1] == -1)
            result[1] = pre;
        return result;
    }
}
