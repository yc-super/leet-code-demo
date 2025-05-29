package 灵神.第k大第k小题单.第K个最小的质数分数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 11, 13, 17, 19};
        int k = 35;
        int[] ints = new Solution().kthSmallestPrimeFraction2(arr, k);
        System.out.println();
    }

    // 方法1,遍历全部点对，使用优先队列（大顶堆）直接获得第k大点对.这种方法没有利用有序性，效率比较低

    // 方法2,多路归并
    /*
     * 可以从n-1个有序队列中依次获取最小的点对
     * arr[0]/arr[1]
     * arr[0]/arr[2],arr[1]/arr[2],
     * arr[0]/arr[3],arr[1]/arr[3],arr[2]/arr[3],
     * 。。。
     * arr[0]/arr[n-1],arr[1]/arr[n-1],arr[2]/arr[n-1]。。。arr[n-2]/arr[n-1]
     * */

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return arr[o1[0]] * arr[o2[1]] - arr[o2[0]] * arr[o1[1]];
            }
        });
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            queue.add(new int[]{0, i});
        }
        int cnt = 0;
        while (cnt < k - 1) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            cnt++;

            if (i + 1 < j) {
                queue.add(new int[]{i+1, j});
            }
        }
        int[] poll = queue.poll();
        return new int[]{arr[poll[0]], arr[poll[1]]};
    }

    // 方法3,二分+双指针（类似题目：找出第K小的数对距离）
    // int[] arr = {1, 2, 3, 5, 7, 11, 13, 17, 19};
    //        int k = 35;
//    public int[] kthSmallestPrimeFraction3(int[] arr, int k) {
//
//    }


    // 自己写的，利用了有序性，但是很多细节没有处理好，比如是否访问过使用了vis，效率一般，以及优先队列里可以直接存储arr[i]和arr[j]，而非i、j
    public int[] kthSmallestPrimeFraction222(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return arr[o1[0]] * arr[o2[1]] - arr[o2[0]] * arr[o1[1]];
            }
        });
        int n = arr.length;
        boolean[][] vis = new boolean[n][n];
        queue.add(new int[]{0, arr.length - 1});
        vis[0][n - 1] = true;
        int cnt = 0;
        int mini = 0, minj = 0;
        while (cnt < k) {
            int[] poll = queue.poll();
            cnt++;
            int i = poll[0];
            int j = poll[1];
            mini = i;
            minj = j;
            if (i + 1 != j) {
                // i右移，i+1,j;
                // j左移,i,j-1
//                int a = arr[i + 1] * arr[j - 1] - arr[i] * arr[j];
//                if (a <= 0) {
                if (!vis[i + 1][j]) {
                    queue.add(new int[]{i + 1, j});
                    vis[i + 1][j] = true;
                }
//                } else {
                if (!vis[i][j - 1]) {
                    queue.add(new int[]{i, j - 1});
                    vis[i][j - 1] = true;
                }
//                }
            }
        }
        return new int[]{arr[mini], arr[minj]};
    }
}
