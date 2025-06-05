package 灵神.第k大第k小题单.查找和最小的K对数字;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 灵神的题解1
class Solution2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 3, 3};
        int[] nums2 = {1, 5, 6};
        int k = 3;
        List<List<Integer>> lists = new Solution2().kSmallestPairs(nums1, nums2, nums1.length * nums2.length);
        System.out.println();
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k); // 预分配空间
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) { // 至多 k 个
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (ans.size() < k) {
            int[] p = pq.poll();
            int i = p[1];
            int j = p[2];
            List<Integer> ll=new ArrayList<>();
            ll.add(nums1[i]);
            ll.add(nums2[j]);
            ans.add(ll);
            if (j + 1 < nums2.length) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return ans;
    }
}
