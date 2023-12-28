package LeetCode.掷骰子等于目标和的方法数;

public class Solution {
    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
        System.out.println(new Solution().numRollsToTarget(n, k, target));
    }

    public int numRollsToTarget(int n, int k, int target) {
        backTrack(0, n, k, target);
        while (result > 1000000007) {
            result -= 1000000007;
        }
        return (int) result;
    }

    private void backTrack(int start, int n, int k, int target) {
        if (start == n) {
            if (target == 0) {
                result++;
            }
            return;
        }
        for (int j = 1; j <= k; j++) {
            target -= j;
            if (n - start-1 > target || (n - start-1) * k < target) {
                return;
            }
            backTrack(start + 1, n, k, target);
            target += j;
        }
    }

    long result = 0;

}
