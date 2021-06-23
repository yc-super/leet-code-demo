package LeetCode.二进制中1的个数;

public class MyCode {
    public static void main(String[] args) {
        int n=-3;//100,111
        /*
        * 111
        * 110
        * 110   1
        * 101
        * 100   2
        * 010
        * 000   3
        *
        * 101
        * 100
        * 100   1
        * 010
        * 000   2
        *
        * 1111
        * 1110
        * 1110  1
        * 1101
        * 1100  2
        * 1011
        *
        *
        * */
        System.out.println(hammingWeight2(n));
    }
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    public static int hammingWeight2(int n) {
        /*String s = Integer.toString(0b11111111111111111111111111111101);
        System.out.println(s);*/
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
