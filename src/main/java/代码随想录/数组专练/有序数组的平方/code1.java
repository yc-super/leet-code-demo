package 代码随想录.数组专练.有序数组的平方;

public class code1 {
    public static void main(String[] args) {
        int[] nums={-1,2,2};
        System.out.println(sortedSquares(nums));
    }
    public static int[] sortedSquares(int[] nums) {
        int len=nums.length;
        int left=0,right=len-1;
        int index=right;
        int[] result=new int[len];
        while(left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                result[index--]=nums[left]*nums[left];
                left++;
            }else{
                result[index--]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
