package LeetCode.两个非重叠子数组的最大和;

public class Solution {
    // 思路：dp
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(method(nums,firstLen,secondLen),method(nums,secondLen,firstLen));
    }

    private int method(int[] nums, int firstLen, int secondLen) {
        int sumL=0,sumR=0;
        for (int i = 0; i < firstLen; i++) {
            sumL+=nums[i];
        }
        int maxL=sumL;
        for (int i = firstLen; i < firstLen+secondLen; i++) {
            sumR+=nums[i];
        }
        int result=sumL+sumR;
        for (int i = firstLen,j=firstLen+secondLen; j<nums.length ; i++,j++) {
            sumL+=nums[i]-nums[i-firstLen];
            maxL=Math.max(maxL,sumL);
            sumR+=nums[j]-nums[j-secondLen];
            result=Math.max(result,maxL+sumR);
        }
        return result;
    }
}
