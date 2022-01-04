package 数组.长度最小的子数组;

public class code {
    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int[] nums = {1,1,1};
        System.out.println(new code().minSubArrayLen2(target,nums));
    }
    //方法1，暴力搜索，没写完
    public int minSubArrayLen(int target, int[] nums) {
        int count=Integer.MAX_VALUE;
        int tem_count;
        int sum;
        int j;
        for (int i = 0; i < nums.length; i++) {
            j=i;
            tem_count=0;
            sum=0;
            while(sum<target&&j<nums.length){
                sum+=nums[j];
                tem_count++;
                j++;
            }
            if(j==nums.length){
                if(sum>=target){
                    count=Math.min(count,tem_count);
                }else {
                    break;
                }
            }else{
                count=Math.min(count,tem_count);
            }
        }
        return count;
    }

    //方法2，滑动窗口
    public int minSubArrayLen2(int target, int[] nums) {
        int len=nums.length;
        int l=0,r=-1;
        int sum=0;
        int count=Integer.MAX_VALUE;
        while(r!=len||l!=len) {
            while (sum < target && r < len-1) {
                r++;
                sum += nums[r];
            }
            if(sum>=target) {
                count = Math.min(count, r-l+1);
                sum -= nums[l];
                l++;
            }else{
               break;
            }
        }
        return count==Integer.MAX_VALUE?0:count;
    }

    //滑动窗口，优化
    public int minSubArrayLen3(int target, int[] nums) {
        int l=0;
        int result=Integer.MAX_VALUE;
        int sum=0;
        for (int r = 0; r < nums.length; r++) {
            sum+=nums[r];
            while(sum>=target){
                result=Math.min(result,r-l+1);
                sum-=nums[l++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
