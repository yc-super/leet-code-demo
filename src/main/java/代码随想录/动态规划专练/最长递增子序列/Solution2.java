package 代码随想录.动态规划专练.最长递增子序列;

class Solution2 {
    public static void main(String[] args) {
//        int[] nums={10,9,2,5,3,7,101,18};
//        int[] nums={1,7,8,5,10,6,7,101,18};
        //          1 2 2 2 3 3  4 5   5
//        int[] nums = {10, 9, 2, 5, 3, 7, 6, 18};
        int[] nums = {10,9,2,5,3,7,101,18};
        //           1 1 1 2 2 3 3 4
        System.out.println(new Solution2().lengthOfLIS2(nums));
    }

    //贪心+二分查找。不过验证dp[i]单调递增这个我不太理解。以后见到log(n)复杂度的，想想能不能二分法查找
    public int lengthOfLIS2(int[] nums) {
        //dp[i]:表示长度为i的最长子序列的末尾元素的最小值
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        int index = 1;
        dp[index] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[index]) {
                dp[++index] = nums[i];
            } else {
                //从dp[i]到dp[i-1]中找到比nums[i]小的，然后覆盖它。
                //认为dp[i]从0到i，值是递增的，找的过程中可以用二分法
                int l = 1, r = index - 1, pos = 0;//如果所有的数都别nums[i]大，此时要更新nums[i]，那么就要更新dp[1]
                while (l <= r) {
                    int middle = (l + r) >> 1;
                    if (dp[middle] < nums[i]) {
                        pos = middle;
                        l = middle + 1;
                    } else {
                        r = middle - 1;
                    }
                }
                dp[++pos] = nums[i];
            }
        }
        return index;
    }


    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
