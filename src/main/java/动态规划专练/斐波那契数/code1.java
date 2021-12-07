package 动态规划专练.斐波那契数;

public class code1 {
    public static void main(String[] args) {
        int n=7;
        /*
         * f0=0
         * f1=1
         * f2=f1+f0=1
         * f3=f2+f1=2
         * f4=f3+f2=3
         * f5=f4+f3=5
         * */
        int result = new code1().fib(n);
        System.out.println(result);
    }
    public int fib(int n) {
        if(n<2)
            return n;
        int q,w=0,e=1;
        for (int i = 2; i <=n ; i++) {
            q=w;
            w=e;
            e=q+w;
        }
        return e;

    }
}
