package 代码随想录.数组专练.移除元素;

public class code2 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        int left=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]!=val){
                nums[left]=nums[i];
                left++;
            }
        }
        return left;
    }
}
