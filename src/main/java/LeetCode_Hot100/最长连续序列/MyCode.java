package LeetCode_Hot100.最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

* 输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
0012345678
* */
//思路1：哈希表，超时了，也有可能是我的思路不对
//思路2：动态规划
//思路3：Arrays.sort，排序，然后遍历一遍，效率还蛮高的。但是并不是题目要求的时间复杂度O(n)，时间复杂度是O(nlogn)
public class MyCode {
    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {1,2,3,4,100,200,205,202,203,204,201};
        int[] nums = {1};
//        int[] nums = {1,2,2,3,4,4,6,8,10,11,12,13,14,15,16};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int i = new MyCode().longestConsecutive2(nums);
        System.out.println(i);
    }

    public int longestConsecutive2(int[] nums) {
        if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int pre=nums[0];
        int count=1;
        int max=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==pre)
                continue;
            if(nums[i]==pre+1){
                count++;
                pre=nums[i];
            }else {
                max=Math.max(max,count);
                pre=nums[i];
                count=1;
            }
        }
        max=Math.max(max,count);
        return max;
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int temp;
        int count;
        int max=1;
        for (int i = 0; i < nums.length; i++) {
            temp=nums[i];
            count=0;
            while(set.contains(temp)){
                temp++;
                count++;
            }
            temp=nums[i]-1;
            while(set.contains(temp)){
                temp--;
                count++;
            }
            max=Math.max(max,count);

        }
        return max;
    }
}
