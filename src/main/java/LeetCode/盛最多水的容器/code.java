package LeetCode.盛最多水的容器;
/*
* 思路：动态规划
* 动态规划5部曲
* 1.确定dp数组及其下标的含义
* dp[i]，表示从下标0到下标i，最大盛水容量
*
* 2.确定递推公式
* 分析：i为0时，dp[i]=0
* dp[i]=
*
* 3.初始化dp数组
* 4.确定顺序
* 5.举例推导
*
* */
//没写出来，看了官方答案，双指针。
public class code {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
//        int[] height={1,2,1};
        System.out.println(maxArea(height));
    }

    //暴力解法，超出时间限制
    public static int maxArea1(int[] height) {
        int length=height.length;
        int max=0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                max=Math.max(max,(i-j)*Math.min(height[i],height[j]));
            }
        }
        return max;
    }
    //官方答案，双指针
    public static int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max=0;
        int index;
        while(l<r) {
            index= Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, index);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
