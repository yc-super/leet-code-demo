package 宫水三叶.错误的集合;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] method = new Solution().method(nums);
        System.out.println(method[0] + "," + method[1]);
    }

    // 3 2 1 2
    public int[] method(int[] nums) {
        // 原地处理
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if(nums[i]==nums[nums[i]-1])
                    break;
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return new int[]{nums[i], i + 1};
        }
        return new int[]{};
    }

    // 2n+b+c
}
