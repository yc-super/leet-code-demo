package Hot100.乘积最大子数组;

//动态规划，效率不尽如人意
public class MyCode {
    public static void main(String[] args) {
//        int[] nums = {2,3,-1,4,2,-2,-1,193};
        /*
        * 2  3  -1  4  2  -2  -1  193
        * 2  3  -6  -24 -48
        * 2  6  -1  4  8
        * 2  6
        * */
//        int[] nums = {-2,0,-1};
        int[] nums = {-2,0,1,2,0,9,-1,3};
        int i = maxProduct(nums);
        System.out.println(i);
    }
    public static int maxProduct(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        dp[0]=nums[0];
        int max;
        int temp;
        for (int i = 1; i < len; i++) {
            if(nums[i]==0) {
                dp[i] = Math.max(dp[i - 1], 0);
                continue;
            }
            max=nums[i];
            temp=nums[i];
            for (int j = i-1; j >=0; j--) {
                if(nums[j]==0){
                    max=Math.max(max,0);
                    break;
                }else {
                    temp*=nums[j];
                    max=Math.max(max,temp);
                }
            }
            dp[i]=Math.max(dp[i-1],max);
        }
        return dp[len-1];
    }
}
