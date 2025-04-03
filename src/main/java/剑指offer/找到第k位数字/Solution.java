package 剑指offer.找到第k位数字;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int kthNumber = new Solution().findKthNumber(99999);
        System.out.println(kthNumber);
    }

    public int findKthNumber(int k) {
        if (k < 10)
            return k;
        long xx = 9, yy = 1;
        while (k > xx * yy) {
            k -= xx * yy;
            xx *= 10;
            yy++;
        }

        int base=myPow((int)yy-1);
        int aa=base+k / (int)yy-1;
        int a = k % (int)yy;
        if(a==0){
            return aa%10;
        }
        aa+=1;
        return (aa/myPow((int)yy-a))%10;
    }

    private int myPow(int a) {
        int result = 1;
        while (a != 0) {
            result *= 10;
            a--;
        }
        return result;
    }
}
