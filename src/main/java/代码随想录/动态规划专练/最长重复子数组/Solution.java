package 代码随想录.动态规划专练.最长重复子数组;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 2, 1};
////        int[] nums2 = {3, 2, 1, 4, 7, 1, 2};
//        int[] nums2 = {3, 2, 3, 2, 1, 4, 7, 1, 2, 3};
        int[] nums1 = {1,0,0,0,1};
        int[] nums2 = {1,0,0,1,1};
        //3,2,3,2,1,4,7,1,2,3
        System.out.println(new Solution().findLength3(nums1, nums2));//3
    }

    public int findLength(int[] nums1, int[] nums2) {
        //笨办法，把nums[2]中的元素存起来，以便在遍历nums1时更好去找nums2中对应元素的下标,O(n3)
        //时间效率非常低，空间还好
        int len1 = nums1.length, len2 = nums2.length;
        List<List<Integer>> lists = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < len2; i++) {
            lists.get(nums2[i]).add(i);
        }
        int result = 0, max = 0;
        for (int i = 0; i < len1; i++) {
            List<Integer> list = lists.get(nums1[i]);
            if (list.size() == 0)
                continue;
            if (len1 - i <= result)//剪枝
                continue;
            for (int j = 0; j < list.size(); j++) {
                if (len2 - list.get(j) <= result)//剪枝
                    continue;
                int l1 = i + 1, l2 = list.get(j) + 1;
                max = 1;
                while (l1 < len1 && l2 < len2 && nums1[l1] == nums2[l2]) {
                    max++;
                    l1++;
                    l2++;
                }
                result = Math.max(result, max);
            }
        }
        return result;
    }

    //动态规划。看了代码随想录之后写出来的
    //一开始没找到dp[i][j]和dp[i-1][j-1]的关系，导致没想出来，没想到dp[i][j]的含义是以nums1[i]、nums2[j]结尾的最长重复子数组的长度
    public int findLength2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int result = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    //滚动数组。不太好理解
    public int findLength3(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int result = 0;
        for (int i = 1; i <= nums1.length; i++) {
//            for (int j = 1; j <= nums2.length; j++) {
            for (int j = nums2.length; j > 0; j--) {//这里需要倒序，以防重复覆盖
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    result = Math.max(result, dp[j]);
                }else{
                    dp[j]=0;
                }
            }
        }
        return result;
    }
}
