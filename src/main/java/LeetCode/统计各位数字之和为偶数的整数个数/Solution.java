package LeetCode.统计各位数字之和为偶数的整数个数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countEven(9));
    }
    public int countEven(int num) {
        int sum=0;
        if(num<10){
            for (int i = 1; i <=num ; i++) {
                if(i%2==0){
                    sum++;
                }
            }
            return sum;
        }
        sum=4;
        sum+=(num/10-1)*5;
        int k,count;
        for (int i = num/10*10; i <=num ; i++) {
            k=i;
            count=0;
            while(k!=0){
                count+=k%10;
                k/=10;
            }
            if(count%2==0)
                sum++;
        }
        return sum;
    }
}
