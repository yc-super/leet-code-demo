package LeetCode.还原排列的最少操作步数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reinitializePermutation(996));
    }
    public int reinitializePermutation(int n) {
        boolean flag;
        boolean f=true;
        int count=0;
        int[] nums=new int[n];
        int[] nums2=new int[n];//原来的数组
        for (int i = 0; i < n; i++) {
            nums2[i]=i;
        }
        int a=n/2;
        while(true){
            count++;
            flag=true;
            for (int i = 0; i < n; i++) {
                if(f) {
                    nums[i] = nums2[i / 2];
                    f=!f;
                }else{
                    nums[i]=nums2[a+(i-1)/2];
                    f=!f;
                }
                if(nums[i]!=i){
                    flag=false;
                }
            }
            if(flag)
                break;
            for (int i = 0; i < n; i++) {
                nums2[i]=nums[i];
            }
        }
        return count;
    }
}
