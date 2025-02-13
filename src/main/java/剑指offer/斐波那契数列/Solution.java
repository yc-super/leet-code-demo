package 剑指offer.斐波那契数列;

// 动态规划第一题，考察动态规划的基本知识
// 初始值、递推公式
public class Solution {
    public int fib(int n) {
        long[] bp=new long[n+1];
        bp[0]=0;
        bp[1]=1;
        for (int i = 2; i <=n ; i++) {
            bp[i]=(bp[i-1]+bp[i-2])%1000000007;
        }
        return (int)(bp[n]);
    }


    public int fib2(int n) {
        if(n<2)
            return n;
        int a=0,b=1,c=1;
        for (int i = 0; i < n-1; i++) {
            c=(a+b)%1000000007;
            a=b;
            b=c;
        }
        return c;
    }
}
