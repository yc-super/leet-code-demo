package LeetCode.平方数之和;

public class MyCode {
    public static void main(String[] args) {
        int c=8;
        Long t1=System.currentTimeMillis();
        boolean flag=judgeSquareSum3(c);
        System.out.println(flag);
        System.out.println("花费时间："+(System.currentTimeMillis()-t1));
    }
    public static boolean judgeSquareSum1(int c) {
        int d=(int)Math.sqrt(c)+1;
        for (int i = 0; i <= d; i++) {
            int k=c-i*i;
            if(k<0)
                return false;
            double dd=Math.sqrt(k);
            if(dd-(int)dd==0)
                return true;
            /*for (int j = 0; j <= d-i; j++) {
                if((i*i+j*j)==c)
                    return true;
            }*/
        }
        return false;
    }
    //双指针
    public static boolean judgeSquareSum2(int c) {
        int a=0;
        int b=(int)Math.sqrt(c);
        while(a<=b){
            if(a*a+b*b==c){
                return true;
            }
            if(a*a+b*b<c){
                a++;//说明如果a不变，b无论怎么变化，都不可能使得a*a+b*b==c，所以要改变a.//说明a在当前值的情况下，b无论怎么变化，都不可能使得a*a+b*b==c，所以要改变a
            }else if(a*a+b*b>c){
                b--;//a不可能去执行 减减 操作，因为上一个if已经说明当a等于(a--)时，所有的b都不满足条件，所以想要a*a+b*b==c，只能去减少b的值
            }
        }
        return false;
    }
    //费马平方和定理：一个非负整数c如果能表示为两个整数的平方和，当且仅当c的所有形如4K+3的质因子的幂均为偶数。
    //思路：找到c的所有4k+3的因子，判断它们是否都是偶数
    public static boolean judgeSquareSum3(int c) {
        for (int i = 2; i*i <= c; i++) {
            if(c%i!=0)
                continue;
            int num=0;
            while(c%i==0){
                c/=i;
                num++;
            }
            if(i%4==3&&num%2!=0)
                return false;
        }
        return c%4!=3;//说明c的质因数只有c和1
    }
}
