package 代码随想录.动态规划专练.背包问题.完全背包.组合总和IV;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import test.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        //完全背包，排列问题-->注意遍历顺序，要先遍历背包，再遍历物品
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];//这边递推公式，永远是dp[背包下标]+=dp[背包下标-nums[物品下标]]
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        // JSONObject转Java Object:
        Student student = new Student();
        student.setName("yc");
        String s = JSON.toJSONString(student);
//        String s = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
        JSONObject jsonObject = JSONObject.parseObject(s);
        // 这里注意，实体类所在包路径中不能包含中文名
        Student student1 = jsonObject.toJavaObject(Student.class);
        System.out.println(student1);

        // JSONObject转Java Object:
        Student student2 = new Student();
        student2.setName("yc2");
        student2.setAge(19);
        String s2 = JSON.toJSONString(student2);
        JSONObject jsonObject2 = JSONObject.parseObject(s2);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject2);
        //注意，toJavaList需要版本为1.2.71的com.alibaba.fastjson依赖
        List<Student> list = jsonArray.toJavaList(Student.class);
        System.out.println(list);
    }

    // 自己想的动态规划
    public int combinationSum5(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] dp = new int[target + 1];
        if (set.contains(1)) {
            dp[1] = 1;
        }
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                if (set.contains(j)) {
                    dp[i] += dp[i - j];
                }
            }
            if (set.contains(i)) {
                dp[i]++;
            }
        }
        return dp[target];
    }
/*
* 3:1,2
* 4:1,2,3
*
* */
}
