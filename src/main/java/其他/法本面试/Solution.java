package 其他.法本面试;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] method(int[] nums,int target){
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
