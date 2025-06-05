package 灵神.第k大第k小题单.查找和最小的K对数字;

import java.util.ArrayList;
import java.util.List;
/*
* 尝试了下二分法，发现有问题，有一个测试用例无法通过，测试用例又没有显示完，无法排查问题。
* 这道题只能用多路归并法
* */
public class reviewCode {
    public static void main(String[] args) {
//        int[] nums1 = {1, 7, 11};
//        int[] nums2 = {2, 4, 6};
//        int k = 9;
        int[] nums1 = {-10,-4,0,0,6};
        int[] nums2 = {3,5,6,7,8,100};
        int k = 10;
        new reviewCode().kSmallestPairs(nums1, nums2, k);
    }

    // 二分+二分
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        int left = nums1[0] + nums2[0], right = nums1[n1 - 1] + nums2[n2 - 1];
        List<List<Integer>> result = new ArrayList<>(k);
        while (left < right) {
            int count = 0;
            int middle = left + right >> 1;
            for (int i = 0; i < n1; i++) {
                int index = getCountFrom(middle - nums1[i], nums2);
                count += index;
                if(nums1[i]+nums2[index]==middle){
                    count++;
                }
            }
            if (k > count) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

//        left--;
        //此时left即为第k大的和，现在开始遍历，将所有小于k的数对加入到result中
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] + nums2[j] < left) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    result.add(list);
                } else {
                    break;
                }
            }
        }

//        此时可能还不够k个，再加入若干个等于k的数对
        for (int i = 0; i < n1 && result.size() < k; i++) {
            for (int j = 0; j < n2 && result.size() < k; j++) {
                if (nums1[i] + nums2[j] == left) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    result.add(list);
                } else if (nums1[i] + nums2[j] > left) {
                    break;
                }
            }
        }

        return result;
    }

    private int getCountFrom(int target, int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int middle = left + right >> 1;
            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
