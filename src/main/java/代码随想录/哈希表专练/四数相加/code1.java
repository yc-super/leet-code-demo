package 代码随想录.哈希表专练.四数相加;

import java.util.HashMap;
import java.util.Map;

public class code1 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result=0;
        int len=nums1.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp=nums1[i]+nums2[j];
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp=nums3[i]+nums4[j];
                if(map.containsKey(0-temp)){
                    result+=map.get(0-temp);
                }
            }
        }
        return result;
    }
}
