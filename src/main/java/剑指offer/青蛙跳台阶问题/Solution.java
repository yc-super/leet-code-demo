package 剑指offer.青蛙跳台阶问题;

public class Solution {
    public int trainWays(int num) {
        if(num<2)
            return 1;
        int a=1,b=1,c=2;
        for (int i = 0; i < num-1; i++) {
            c=(a+b)%1000000007;
            a=b;
            b=c;
        }
        return c;
    }
}
