package 剑指offer.寻找旋转排序数组中的最小值II;

// 这道题目咋一看是贪心题，找到有下降趋势的那个节点就行了。这种方法很好想，但是时间复杂度是O（n）
// 其实看到有序数组，第一想到的就应该是二分法。
public class Solution {
    // 方法1
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<nums[i-1])
                return nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] array={3,1,1};
        int min2 = new Solution().findMin2(array);
        System.out.println(min2);
    }

    // 方法2。技巧：保持一个等于middle(right)，一个动（left），可以更好处理边界问题，到时候直接返回left，
    // 因为是最后left的移动导致了跳出二分循环
    public int findMin2(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int left=0,right=nums.length-1;
        while(left<right){
            int middle=(left+right)>>1;
            if(nums[middle]>nums[right]){
                left=middle+1;
            }else if(nums[middle]<nums[right]){
                right=middle;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
