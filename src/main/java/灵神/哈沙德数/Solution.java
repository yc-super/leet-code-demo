package 灵神.哈沙德数;

public class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int a = 0;
        int temp = x;
        while (temp != 0) {
            a = a + temp % 10;
            temp /= 10;
        }
        if (x % a == 0) {
            return a;
        } else {
            return -1;
        }
    }
}
