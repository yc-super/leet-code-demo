package 代码随想录.贪心算法.摆动序列;

public class Solution {
    public static void main(String[] args) {
        /*
        nums=1, 7, 4, 9, 2, 5       6
        nums=1,6, 7, 4, 9, 2, 5       6
        nums=1,2,3, 7, 8, 9, 8,7,4,3, 5       1,2,3随便选一个，6
        nums=1,2,1,2,1, 7, 4, 9, 2, 5
        * */
//        int[] nums={1,2,1};
//        int[] nums={1,2};
//        int[] nums={1,1,1,2,1,1,1,1,3,3,3,3};
//        int[] nums={1, 2,7,7,7,7, 4, 9, 2, 5};
        int[] nums = {0, 0, 0, 1};
        System.out.println(new Solution().wiggleMaxLength(nums));
    }

    //想象一个折线图，最终结果就是顶点个数，利用一个布尔值来描述是上升趋势还是下降趋势
    //贪心算法
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 1;
        if (len == 2) {
            if (nums[0] != nums[1]) {
                return 2;
            } else {
                return 1;
            }
        }
        int count = 1;
        boolean flag;
        int i = 1;
        while (i < len && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i == len)
            return 1;
        while (len >= i && nums[len - 1] == nums[len - 2]) {
            len--;
        }
        if (nums[i] > nums[i - 1]) {
            flag = true;
        } else {
            flag = false;
        }
        while (i < len) {
            if (flag) {
                while (i < len && nums[i] >= nums[i - 1]) {
                    i++;
                }
                count++;
                flag = !flag;
            } else {
                while (i < len && nums[i] <= nums[i - 1]) {
                    i++;
                }
                count++;
                flag = !flag;
            }
        }
//       count++;
        return count;
    }

    //代码随想录 贪心算法，比我的更简洁，效率比我的低一点
    public int wiggleMaxLength2(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;
        int count = 1;
        int preDiff = 0;
        int curDiff;
        for (int i = 1; i < len; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    //代码随想录 dp 看着效率就比较低，这题不适合动态规划
    public int wiggleMaxLength3(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;
        //dp[i][0]代表把nums[i]当成山峰，dp[i][1]代表把nums[i]当成山谷
        //dp[i][0]=Math.max(dp[i][0],dp[j][1]+1)
        //dp[i][1]=Math.max(dp[i][1],dp[j][0]+1)
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                //i作为山谷
                if (nums[j] > nums[i])
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                //i作为山峰
                if (nums[j] < nums[i])
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
            }
        }
        //i作为山谷或山峰较大的那一个
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
