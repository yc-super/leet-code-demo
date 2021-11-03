package 动态规划专练.代码随想录.斐波那契数;
//力扣509
//方式1，递归，比较容易想出来，缺点是有重复计算（重复计算树节点的值）
public class Code {
    public static void main(String[] args) {
        int n=4;
        int result = fib(n);
        System.out.println(result);
    }
    public static int fib(int n) {
        return fixProblem(n);
    }

    private static int fixProblem(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fixProblem(n-1)+fixProblem(n-2);
    }
}
