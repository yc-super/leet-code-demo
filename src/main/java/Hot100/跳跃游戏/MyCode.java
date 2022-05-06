package Hot100.跳跃游戏;

public class MyCode {
    public static void main(String[] args) {
//        int[] nums= {2,3,1,1,4};
//        int[] nums= {1,1,2,0,0,1,1,2,0,1};
        int[] nums= {100,1,2,0,0,1,1,2,0,1};
        boolean b = new MyCode().canJump(nums);
        System.out.println(b);
    }
    public boolean canJump(int[] nums) {
        int len=nums.length;
        if(len==1)
            return true;

        if(nums[0]>=len)
            return true;

        if(nums[0]==0)
            return false;

        int i;
        boolean flag;
        for (i = len-2; i >=0; i--) {
            if(nums[i]!=0){
                continue;
            }
            flag=false;
            for (int j = i-1; j >=0; j--) {
                if(j+nums[j]>i) {
                    flag=true;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        if(i<=0)
            return true;

        return false;
    }

}
