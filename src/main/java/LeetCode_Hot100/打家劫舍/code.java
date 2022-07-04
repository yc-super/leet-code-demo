package LeetCode_Hot100.打家劫舍;


public class code {
    public static void main(String[] args) {
//        int[] nums={2,7,1,1,9,1};
//        int[] nums={2,7,9,3,1};
//        int[] nums={1,2,3,1};
        int[] nums={8,1,1,1,2,1,8};
//        int[] nums={10,20,1,1,1,20};
        int rob = rob(nums);
        System.out.println(rob);
    }

    //实际之前的动态规划已经很好了，考虑到节点i处的值只和前两个有关系，因此可以优化为滚动数组
    private static int rob(int[] nums) {
        int len=nums.length;
        if(len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
        int x=nums[0];
        int y=Math.max(nums[0],nums[1]);
        int temp;
        for (int i = 2; i < len; i++) {
            temp=y;
            y=Math.max(x+nums[i],y);
            x=temp;
        }
        return y;
    }
}
