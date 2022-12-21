package 代码随想录.贪心算法.跳跃游戏;

public class Solution {
    //第一想到的是dp
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        if (nums[0] == 0)
            return false;
        int len=nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        int temp=nums[0];
        if(temp>=len)
            return true;
        while(!dp[temp]){
            dp[temp--]=true;
        }
        for (int i = 1; i < len; i++) {
            if (!dp[i])
                return false;
            temp=i+nums[i];
            if(temp>=len)
                return true;
            while(!dp[temp]){
                dp[temp--]=true;
            }
        }
        return true;
    }

    //贪心，不断更新最远能到达的位置，直到出现两种情况之一：
    // 如果最远能到达的位置小于当前下标，直接返回false；如果最远能到达的位置大于len-1，直接返回ture
    public boolean canJump2(int[] nums) {
        int len=nums.length;
        int maxIndex=0;
        for (int i = 0; i < len; i++) {
            if(maxIndex>=i) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= len - 1)
                    return true;
            }else{
                break;
            }
        }
        return false;
    }
}
