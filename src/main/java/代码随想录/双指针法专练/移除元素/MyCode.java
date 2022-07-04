package 代码随想录.双指针法专练.移除元素;

//力扣27 简单
public class MyCode {
    public static void main(String[] args) {
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;
        System.out.println(removeElement(nums,val));
    }
    public static int removeElement(int[] nums, int val) {
        if(nums==null)
            return 0;
        int l=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
               nums[l]=nums[i];
               l++;
            }
        }
        return l;
    }
}
