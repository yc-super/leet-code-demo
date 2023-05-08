package 其他.华为od;

import java.util.Arrays;
import java.util.Scanner;

public class MVP争夺战 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String s = in.nextLine();
        String[] str = s.split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(nums);
        int total = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
            total += num;
        }
        int result = total;
        //把m个分数平均分给i个人
        for (int i = 2; i <= m; i++) {
            if (total / i > maxValue)
                break;
            if (total % i != 0)
                continue;
            //1个人分得total/i分，检查nums中是否可以划分成均等的i个total/i

            //如果可以
            result=total/i;
        }
        System.out.println(result);
    }
}
