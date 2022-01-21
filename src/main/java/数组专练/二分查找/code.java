package 数组专练.二分查找;

import java.util.Arrays;

public class code {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 13;
//        int[] nums = {2};
//        int target = 1;
        System.out.println(new code().search(nums,target));
    }

    public int search(int[] nums, int target) {
        int index=Arrays.binarySearch(nums,target);
        return index<-1?-1:index;
    }
    public int search2(int[] nums, int target) {
        if(nums[0]>target||nums[nums.length-1]<target)
            return -1;
        int l=0;
        int r=nums.length-1;
        int middle=0;
        while(l<=r){
            middle=(r+l)>>1;
            if(nums[middle]>target){
                r=middle-1;
            }else if(nums[middle]<target){
                l=middle+1;
            }else{
                return middle;
            }
        }
        return nums[middle]==target?middle:-1;

    }
}
