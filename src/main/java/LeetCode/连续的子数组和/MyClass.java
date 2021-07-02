package LeetCode.连续的子数组和;

import java.util.HashMap;
import java.util.Map;

/*
* 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：

子数组大小 至少为 2 ，且
子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。

如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数

*
* 输入：nums = [23,2,4,6,7], k = 6
输出：true
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
*
*
* 输入：nums = [23,2,6,4,7], k = 6
输出：true
解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。

* */
public class MyClass {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k=6;
        System.out.println(checkSubarraySum3(nums,k));
    }
    //1.暴力解法，先利用这个解法来理清思路
    //暴力解法无法枚举所有可能
    public static boolean checkSubarraySum(int[] nums, int k) {
        int length=nums.length;
        if(length<2)
            return false;
        for (int i = 2; i < length; i++) {//i代表子数组的元素个数
            for (int j = 0; j < length-1; j++) {//j代表
                for (int l = j+1; l < length; l++) {

                }
            }

        }
        return false;
    }
    //数论中的重要概念。给定一个正整数m，如果两个整数a和b满足a-b能够被m整除，即(a-b)/m得到一个整数，
    // 那么就称整数a与b对模m同余，记作a≡b(mod m)。
    //19-4=15,m=5,15/5=3,那么19/5和4/5的余数相同，都为4

//    输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
    //prefixSums为nums的前缀和
    //prefixSums:{0,23,25,29,35,42}
    //各个元素除以k的余数：{0,5,1,5,5,0}

//    输入：nums = [23,2,6,4,7,3], k = 6
//    输出：true
//    解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
//            42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
    //prefixSums为nums的前缀和
    //prefixSums:{0,23,25,31,35,42,45}

    //官方答案，同余定理
    //同余定理：当 {prefixSums}[q]-{prefixSums}[p] 为 k 的倍数时，
    // {prefixSums}[p]和 {prefixSums}[q]除以 k 的余数相同
    public boolean checkSubarraySum2(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
    //    输入：nums = [23,2,6,4,7,3], k = 6
//    输出：true
//    解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
//            42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
    //prefixSums为nums的前缀和
    //prefixSums:{0,23,25,31,35,42,45}

    //利用官方的思路，在不看官方代码前，自己尝试一下
    public static boolean checkSubarraySum3(int[] nums, int k) {
        //1,计算prefixSums为nums的前缀和
        int length=nums.length;

        if(length<2)
            return false;

        int[] prefixSums=new int[length+1];
        prefixSums[0]=0;
        for (int i = 0; i < length; i++) {
            prefixSums[i+1]=prefixSums[i]+nums[i];
        }
        //2.遍历prefixSums，并将各个元素除以k的余数以及下标存入map中，如果map中已经有了相同的余数，则取出之前的下标，
        //当前下标减去之前的下标，如果大于1，则返回TRUE；否则不记录当前下标
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < length+1; i++) {
            if(map.containsKey(prefixSums[i]%k)){
                Integer index = map.get(prefixSums[i] % k);
                if(i-index>1)
                    return true;
            }else{
                map.put(prefixSums[i]%k,i);
            }
        }
        return false;
    }
}
