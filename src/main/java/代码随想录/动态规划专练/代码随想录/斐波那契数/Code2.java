package 代码随想录.动态规划专练.代码随想录.斐波那契数;

public class Code2 {
    public static void main(String[] args) {
        int n=4;
        int result = fib(n);
        System.out.println(result);
    }
    public static int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int i=0,j=1,k=0;
        for (int l = 2; l <= n; l++) {
            k=i+j;
            i=j;
            j=k;
        }
        return k;
    }
}
