package LeetCode_Hot100.和为K的子数组;

import com.alibaba.fastjson.JSONObject;
import 测试.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
//    public static void main(String[] args) {
////        int[] nums = {1,2,3};
////        int k = 3;
//        int[] nums = {1,-1,0};
//        int k = 0;
//        int i = new Solution().subarraySum3(nums, k);
//        System.out.println();
//    }

    public static void main(String[] args) {
        Student s1=new Student("yc1",12);
        Student s2=new Student("yc2",22);
        Student s3=new Student("yc3",22);
        Integer age=null;
        Student s4=new Student("yc4",age);
        List<Student> list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
//        Map<Integer, List<Student>> collect = list.stream().collect(Collectors.groupingBy(item -> item.getAge()));
//        System.out.println();


        Set<String> set=new HashSet<String>() ;
        if(set.contains(null)){
            System.out.println(1234);
        }
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            if (temp == k) {
                count++;
            }
            int j = i + 1;
            while (j < len) {
                temp += nums[j];
                j++;
                if (temp == k) {
                    count++;
                }
            }

        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int[] array = new int[len];
        array[0] = nums[0];
        if (array[0] == k) {
            count++;
        }
        for (int i = 1; i < len; i++) {
            array[i] = array[i - 1] + nums[i];
            if (array[i] == k) {
                count++;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                array[j] -= nums[i];
                if (array[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int[] sum = new int[len+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i-1];
        }
        map.put(0,1);
        for (int i = 1; i <= len; i++) {
            count += map.getOrDefault(sum[i]-k,0);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return count;
    }
}
