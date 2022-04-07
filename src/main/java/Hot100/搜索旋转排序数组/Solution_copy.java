package Hot100.搜索旋转排序数组;

public class Solution_copy {
    public static void main(String[] args) {
        int[] nums={5,1,3};
//        int[] nums={0};
        int target=3;
        int search = new Solution_copy().search(nums, target);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        if(nums.length==1)
            return target==nums[0]?0:-1;
        int l=0,r=nums.length-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[l]<=nums[mid]){
                if(nums[l]<=target&&target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
