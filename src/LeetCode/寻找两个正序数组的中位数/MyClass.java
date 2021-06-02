package LeetCode.寻找两个正序数组的中位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
* 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
*
* 输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
*
* 输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

*
* 输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
*
* 输入：nums1 = [], nums2 = [1]
输出：1.00000
* */
public class MyClass {
    public static void main(String[] args) {
//        new PriorityQueue();
//        int nums1[]={1,2,4,6};
        int nums1[]={0,1};
        int nums2[]={0,1};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //1,2
        //3,5
        //将nums2按大小顺序添加到array
        ArrayList<Integer> array = new ArrayList<>();
        int num=nums1.length;
        for (int i = 0; i < num; i++) {
            array.add(nums1[i]);
        }
        int i=0;
        for (int j = 0; j < num&&i<nums2.length; j++) {
            if(array.get(j)>nums2[i]){
                array.add(j,nums2[i]);
                num++;
                i++;
            }
        }
        if(i<nums2.length){
            for (int j = i; j < nums2.length; j++) {
                array.add(nums2[j]);
            }
        }
        if(array.size()%2==0)
            return (double)(array.get(array.size()/2)+array.get((array.size()/2)-1))/2;
        return array.get(array.size()/2);
    }
}
