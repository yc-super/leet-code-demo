package LeetCode.得到子序列的最少操作次数;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] t={6,4,8,1,3,2};
        int[] arr={4,7,6,2,3,8,6,1};
        System.out.println(new Solution().minOperations(t,arr));
    }
    public int minOperations(int[] t, int[] arr) {
        int n = t.length, m = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(t[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = arr[i];
            if (map.containsKey(x)) list.add(map.get(x));
        }
        int len = list.size();
        int[] f = new int[len], g = new int[len + 1];
        Arrays.fill(g, Integer.MAX_VALUE);
        int max = 0;
        for (int i = 0; i < len; i++) {
            int l = 0, r = len;//这里的二分法没看明白，不知道它是怎么简化原本O（n^2）变为O（nlogn）的。主要是贪心数组g的含义理解不够透彻
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (g[mid] < list.get(i)) l = mid;
                else r = mid - 1;
            }
            int clen = r + 1;
            f[i] = clen;
            g[clen] = Math.min(g[clen], list.get(i));
            max = Math.max(max, clen);
        }
        return n - max;
    }
}
