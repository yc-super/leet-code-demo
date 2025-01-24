package 剑指offer.数组中重复的数字;

// 考察对哈希的掌握。进阶：考察算法能力，如何使用O（1）空间复杂度解决问题，“归笼”法。
// 其实说到O（1）空间复杂度，涉及到数组的，那就往数组原地交换这个思路想
public class Solution {
    // 方法1，很好想，哈希。低级哈希用set，高级一点的使用长度为n的数组做哈希映射。
    public int findRepeatNumber(int[] nums) {
        return -1;
    }
    // 方法2，很巧妙，原地交换位置（鸽巢原理），时间复杂度O（n），但是空间复杂度优化到了O（1）
    // 不断交换 当前下标值 和 值对应的下标对应的值，如果相等那就直接返回。如果不等就交换，
    // 如果当前下标等于当前下标值，那就“归笼”了，那就检查下一个下标，让它也归笼
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while(i!=nums[i]){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                // 将nums[i]和nums[nums[i]]交换
                temp=nums[i];
                nums[i]=nums[nums[i]];
                nums[temp]=temp;
            }
        }
        // 如果不存在，返回-1（刚好每种数字都出现一次，最后都“归笼”了）
        return -1;
    }
}
