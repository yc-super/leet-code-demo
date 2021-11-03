package 动态规划专练.代码随想录.爬楼梯;
//力扣3
/*实际是斐波那契数，关键点：爬第n层楼梯一共有两种情况：
1.爬到第n-1层，然后再爬一层
2.爬到第n-2层，然后再爬两层
f(n)=f(n-1)+f(n-2)
注意f(0)为何是1----->关于这点很重要，不应该考虑f(0)的值，f(0)的值无所谓，f(1)确定是1,f(2)确定是2，可以用这两个继续往后推
*/
public class Code {
    public static void main(String[] args) {
        int n=4;//1,2,3,5
        int m=2;
        int result = climbStairs(n);
        System.out.println(result);
    }
    public static int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int i=1,j=2,k=3;
        for (int l = 3; l <= n; l++) {
            k=i+j;
            i=j;
            j=k;
        }
        return k;
    }
}
