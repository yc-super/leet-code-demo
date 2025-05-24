package 宫水三叶.将数字变成0的操作次数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(8));
    }
    public int numberOfSteps(int num) {
        return myMethod(num);
    }

    private int myMethod(int num) {
        if (num == 0)
            return 0;
        if (num % 2 == 0) {
            return myMethod(num / 2) + 1;
        } else {
            if(num==1)
                return 1;
            return myMethod((num - 1) / 2) + 2;
        }
    }
}
