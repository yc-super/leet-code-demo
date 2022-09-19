package 代码随想录.栈与队列.滑动窗口最大值;

//思路：记录k个数中最大的那个的下标，往右移一格时，检查移除的那个下标是不是最大值的下标，如果是，就要重新遍历新的k个数，找到最大值，如果不是，最大值不变
public class Solution {
    public static void main(String[] args) {
//        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] nums={1,3,-1,2,-1,-1,-1};//{3,4}
        int k=3;
        int[] result = maxSlidingWindow(nums, k);
        for(int num:result){
            System.out.println(num);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int max=Integer.MIN_VALUE;
        if(k>=len){
            for (int i = 0; i < len; i++) {
                if(nums[i]>max)
                    max=nums[i];
            }
            return new int[]{max};
        }

        int[] result=new int[len-k+1];
        int result_index=0;
        int j;
        int max_index=-1;
        for (int i = 0; i <= len-k; i++) {
            j=i+k-1;
            if(i-1==max_index){
                max=Integer.MIN_VALUE;
                for (int l = i; l <= j; l++) {
                    if(nums[l]>=max) {
                        max = nums[l];
                        max_index=l;
                    }
                }
            }else{
                if(nums[j]>=max){
                    max = nums[j];
                    max_index=j;
                }
            }
            result[result_index++]=max;
        }
        return result;
    }
}
