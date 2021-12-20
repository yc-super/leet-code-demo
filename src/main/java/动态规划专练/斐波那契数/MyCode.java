package 动态规划专练.斐波那契数;

public class MyCode {
    public static void main(String[] args) {
        int n=0;
        /*
        * f0=0
        * f1=1
        * f2=f1+f0=1
        * f3=f2+f1=2
        * f4=f3+f2=3
        * f5=f4+f3=5
        * */
        int result = new MyCode().fib(n);
        System.out.println(result);
    }
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fib(n-1)+fib(n-2);
    }
}
