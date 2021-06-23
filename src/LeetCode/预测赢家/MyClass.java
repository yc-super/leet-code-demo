package LeetCode.预测赢家;

public class MyClass {
    public static void main(String[] args) {
        int[] nums={1, 5, 2};
//        int[] nums={3, 2, 1, 5, 4};
        System.out.println(PredictTheWinner(nums));
    }
    public static boolean PredictTheWinner(int[] nums) {
        //如果nums长度为偶数，则玩家1必定获胜（877. 石子游戏）
        int length=nums.length;
        if(length%2==0)
            return true;

        //对于奇数，第一种方法：递归
        int max1=0;//记录玩家1的分数
        int max2=0;//记录玩家2的分数
        int right;

        for (int left = 0; left < length-2; left++) {//i相当于left,
            //玩家2在left和right中选择一个最大的，玩家1选择较小的
            right=left++;
            if(nums[left]>nums[right]){
                max2+=nums[left];
                max1+=nums[right];
            }else{
                max1+=nums[left];
                max2+=nums[right];
            }
            while(!(left-1==0&&right+1==length-1)) {
                //接下来玩家1选择nums[left]和nums[right]中的小的,直到left==0并且right==length-1
                if (left > 0) {
                    left--;
                }
                if (right < length - 1) {
                    right++;
                }

            }

        }
        return max1>=max2;
    }
}
