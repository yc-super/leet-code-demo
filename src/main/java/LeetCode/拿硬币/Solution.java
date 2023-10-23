package LeetCode.拿硬币;

public class Solution {
    public int minCount(int[] coins) {
        int result = 0;
        for (int x : coins) {
            if (x == 1) {
                result++;
            } else {
                result += (x + 1) / 2;
            }
        }
        return result;
    }
}
