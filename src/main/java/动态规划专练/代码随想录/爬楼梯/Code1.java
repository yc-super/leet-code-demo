package 动态规划专练.代码随想录.爬楼梯;
//题目变形：如果一步一个台阶，两个台阶，三个台阶，直到 m个台阶，有多少种方法爬到n阶楼顶
/*关键点：爬第n层楼梯一共有m种情况：
        1.爬到第n-1层，然后再爬1层
        2.爬到第n-2层，然后再爬2层
        3.爬到第n-3层，然后再爬3层
        ...
        m.爬到第n-m层，然后再爬m层
        f(n)=f(n-1)+f(n-2)+f(n-3)+...+f(n-m)
        注意f(0)是1----->这里必须知道f(0)是1，可由上个题目推出
        */
public class Code1 {
    public static void main(String[] args) {
        int n=5;
        //1,2,3,5,8
        //1,2,3,5,8
        //1,2,4,7,13

        int m=3;
        int result = climbStairs(n,m);
        System.out.println(result);
    }
    public static int climbStairs(int n,int m) {
        int[] array=new int[n+1];
        array[0]=1;
        array[1]=1;
        array[2]=2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i-j>=0)
                array[i]+=array[i-j];
            }
        }
        return array[n];
    }

    private static int getValue(int n) {
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
