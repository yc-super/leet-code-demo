package 代码随想录.数组专练.二分查找;

public class code1 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 33;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int middle;
        while(left<=right){
            middle=(left+right)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return -1;
    }
}
