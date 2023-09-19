package LeetCode.宝石补给;

public class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] aa : operations) {
            int temp = gem[aa[0]] / 2;
            gem[aa[0]] -= temp;
            gem[aa[1]] += temp;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : gem) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        return max - min;
    }
}
