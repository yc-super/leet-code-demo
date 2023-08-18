package 代码随想录.数组专练.长度最小的子数组;

public class code2 {
    public static void main(String[] args) {
        int target=7;
        int[] nums={2,3,1,2,4,3};
//        int[] nums={7};
        System.out.println(minSubArrayLen(target,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int result = len + 1;
        int left = 0, right = 0, nowCount = 0;
        while (left <= right ) {
            if (nowCount < target&&right!=len) {
                nowCount += nums[right];
                right++;
            } else if(nowCount>=target) {
                result = Math.min(result, right - left);
                nowCount -= nums[left];
                left++;
            }else{
                break;
            }
        }
        return result == len + 1 ? 0 : result;
    }

    // 滑动窗口
    public int minSubArrayLen2(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

