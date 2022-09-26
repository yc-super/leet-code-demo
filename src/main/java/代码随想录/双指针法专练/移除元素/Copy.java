package 代码随想录.双指针法专练.移除元素;

public class Copy {
    public static void main(String[] args) {
        int[] nums={3,3,3,1};
        int val=3;
        int i = removeElement(nums, val);
    }
    public static int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0)
            return 0;
        int left=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[left++]=nums[i];
            }
        }
        return left;
    }
}
