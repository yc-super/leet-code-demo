package LeetCode.范围内最接近的两个质数;

public class Solution {
    public static void main(String[] args) {
        int[] ints = new Solution().closestPrimes(10, 1000000);
        System.out.println(ints[0]+","+ints[1]);

    }
    public int[] closestPrimes(int left, int right) {
        if(left<=2){
            if(right>=3) {
                return new int[]{2, 3};
            }else{
                return new int[]{-1, -1};
            }
        }
        int num1 = nextVal(left-1);
        if (num1 > right)
            return new int[]{-1, -1};
        int num2 = nextVal(num1);
        if (num2 > right)
            return new int[]{-1, -1};
        int min=Integer.MAX_VALUE;
        int min1=0,min2=0;
        while(num2<=right){
            if(num2-num1==2)
                return new int[]{num1, num2};
            if(num2-num1<min){
                min1=num1;
                min2=num2;
                min=num2-num1;
            }
            num1=num2;
            num2=nextVal(num2);
        }
        return new int[]{min1, min2};
    }

    private boolean isValid(int num) {
        if (num <= 1)
            return false;
        int n = (int)Math.sqrt(num);
        for (int i = 2; i <= n; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private int nextVal(int num) {
        num++;
        while (!isValid(num)) {
            num++;
        }
        return num;
    }
}
