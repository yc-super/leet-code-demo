package 动态规划专练.斐波那契数;

public class code2 {
    public static void main(String[] args) {
        //递归效率低的根本原因是，几乎每个节点计算了两次，时间复杂度是O(N^2)
        //解决思路：可以通过一个数组来记录计算过的节点值
        int n=7;
        int result=new code2().fib(n);
    }

    private int fib(int n) {
        int[] array=new int[n+1];
        array[1]=1;
        array[2]=1;
        helper(array,n);
        return 1;
    }

    private void helper(int[] array, int n) {
        
    }
}
