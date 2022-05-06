package Hot100.只出现一次的数字;

import java.util.HashMap;
import java.util.Map;

public class MyCode {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        int i = new MyCode().singleNumber2(nums);
        System.out.println(i);
    }
    //可以得到正确结果，但是用了O（n）的空间复杂度
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map =new HashMap();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,2);
            }else{
                map.put(i,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return nums[0];
    }

    //官方答案，异或，把数组中所有的数异或，最终结果就是那个只出现一次的数，因为出现两次的数，异或会等于0
    public int singleNumber2(int[] nums) {
        int single=0;
        for(int i:nums){
            single=single^i;
        }
        return single;
    }
}
