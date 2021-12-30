package 数组.移除元素;

public class code {
    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {2};
        /*
        * 0,1,2,2,3(l)(r),0,4,2
        * 0,1,4,0,3(l)(r),0,4,2
        *
        * */
        int val = 2;
        System.out.println(new code().removeElement(nums,val));
    }
    public int removeElement3(int[] nums, int val) {
        int fastIndex=0;
        int slowIndex=0;
        for(;fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex]!=val){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
    public int removeElement2(int[] nums, int val) {
        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        int l=0,r=len-1;
        while (l<r){
            while(r>l&&nums[r]==val){
                r--;
            }
            if(r==l){
                return nums[l]==val?l:l+1;
            }
            while(l<r&&nums[l]!=val){
                l++;
            }
            if(l==r){
                return nums[l]==val?l:l+1;
            }
            nums[l]=nums[r];
            r--;
            l++;
        }
        if(l==r)
            return nums[l]==val?l:l+1;
        else
            return r+1;
    }
}
