package LeetCode.只出现一次的数字II;

public class Solution {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int num : nums) {
                temp += num >>> i & 1;
            }
            result |= temp % 3 << i;
        }
        return result;
    }
}
