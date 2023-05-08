package LeetCode.倍数求和;

public class Solution {
    /*
     * 容斥原理，具体：https://leetcode.cn/problems/sum-multiples/solutions/2241283/o1-rong-chi-yuan-li-by-endlesscheng-yxc4/
     * 包含2部分，1是1-n内可以整除i的有n/i个数
     * 2是利用等差数列公式  c*(c+1)/2
     * 把两者结合再乘以i，就是和
     * */

    public int sumOfMultiples(int n) {
        return sum(3, n) + sum(5, n) + sum(7, n) - sum(15, n) - sum(21, n) - sum(35, n) + sum(105, n);
    }

    private int sum(int i, int n) {
        return (n / i) * (n / i + 1) / 2 * i;
    }
}
