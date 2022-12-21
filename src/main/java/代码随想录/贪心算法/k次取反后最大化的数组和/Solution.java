package 代码随想录.贪心算法.k次取反后最大化的数组和;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    //我自己写的，实际上这也不算贪心，就是按照逻辑来写就行了，我比较讨厌这种题目，需要考虑的情况很多，不够简洁，感觉不像个算法
    public int largestSumAfterKNegations(int[] nums, int k) {
        int count=0;
        Arrays.sort(nums);
        int minIndex=0;
        int minCount=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0)
                minCount++;
            if(Math.abs(nums[i])<Math.abs(nums[minIndex]))
                minIndex=i;
        }
        if(k>=minCount){
            k-=minCount;
            if(k%2==1){
                count-=2*Math.abs(nums[minIndex]);
            }
            for(int num:nums){
                count+=Math.abs(num);
            }
        }else{
            int index=0;
            while(k>0){
                nums[index]=-nums[index];
                k--;
                index++;
            }
            for(int num:nums){
                count+=num;
            }
        }
        return count;
    }
}
