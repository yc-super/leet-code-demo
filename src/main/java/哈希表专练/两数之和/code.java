package 哈希表专练.两数之和;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class code {
    public static void main(String[] args) {
//        int[] nums = {3,2,7,11,15};
        int[] nums = {3,3,3};
        int target = 6;
        int[] re=new code().twoSum(nums,target);
        for(int i:re){
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
