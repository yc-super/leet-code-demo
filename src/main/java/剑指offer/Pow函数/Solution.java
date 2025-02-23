package 剑指offer.Pow函数;

public class Solution {
    public static void main(String[] args) {
        double v = new Solution().Pow(2, -4);
        System.out.println(v);
    }

    // 分治法
    public double myPow(double x, int n) {
        if (x == 0 || x == 1)
            return x;
        if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (n == 0)
            return 1;
        if (n > 0)
            return myPow2(x, n);
        return myPow3(x, n);
    }

    private double myPow3(double x, int n) {
        if(n==-1)
            return 1/x;
        double v = myPow3(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * (1/x);
        }
    }

    private double myPow2(double x, int n) {
        if (n == 1) {
            return x;
        }
        double v = myPow2(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }


    // 题解方法更简洁，思路相同
    public double Pow(double x, int n) {
        if (x == 0.0d)
            return 0.0d;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0d;
        while (b > 0) {
            if ((b & 1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
