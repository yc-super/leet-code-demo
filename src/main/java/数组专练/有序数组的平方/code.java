package 数组专练.有序数组的平方;

public class code {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
//        int[] nums = {-10,-3};
        int[] nums2=new code().sortedSquares2(nums);
        for(int i:nums2){
            System.out.println(i);
        }
    }
    public int[] sortedSquares2(int[] nums) {
        int l=0,r=nums.length-1;
        int[] nums2=new int[r+1];
        int j=r;
        while(l<r){
            if(Math.abs(nums[l])>=Math.abs(nums[r])){
                nums2[j--]=nums[l]*nums[l];
                l++;
            }else{
                nums2[j--]=nums[r]*nums[r];
                r--;
            }
        }
        nums2[j--]=nums[r]*nums[r];
        return nums2;
    }
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int len=nums.length;
        int[] nums2=new int[len];
        int j=0;
        for (; i < len; i++) {
            if(nums[i]>=0)
                break;
        }
        if(i==len)
            i--;
        int l=i-1,r=i;
        while (l>=0&&r<len){
            if(Math.abs(nums[l])>=Math.abs(nums[r])){
                nums2[j++]=nums[r]*nums[r];
                r++;
            }else{
                nums2[j++]=nums[l]*nums[l];
                l--;
            }
        }
        while(l>=0){
            nums2[j++]=nums[l]*nums[l];
            l--;
        }
        while(r<len){
            nums2[j++]=nums[r]*nums[r];
            r++;
        }
        return nums2;
    }
}
