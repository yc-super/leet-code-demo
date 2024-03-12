package LeetCode.求一个整数的惩罚数;

public class Solution {
    public static void main(String[] args) {
        int i = new Solution().punishmentNumber(91);
        System.out.println();
    }
    static final int MAX = 1000;
    static final int[] F = new int[MAX + 1];

    static {F[1] = 1;}

    public int punishmentNumber(int n) {
        if (F[n] > 0)
            return F[n];
        return F[n] = (valid(n * n, n) ? n * n : 0) + punishmentNumber(n - 1);
    }

    boolean valid(int s, int n) {
        if (s < n) return false; // s 比 n 小，拆位之后的总和只会比 n 更小
        if (s == n) return true;
        for (int base = 10; base <= s; base *= 10) {
            if (valid(s / base, n - s % base)) return true;
        }
        return false;
    }
    // 其实可以去掉 s < n 的判断，让代码更精简。
    // 因为如果 s < n，就算进入后续的循环和递归，也一样不会返回 true，不影响最终结果。
    // 留下 s < n 的好处是可以提前中止后续没必要的循环和递归。
}