package 代码随想录.哈希表专练.四数相加;

import java.util.HashMap;
import java.util.Map;

public class code {
    public static void main(String[] args) {

    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums1.length;
        int k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                k=nums1[i]+nums2[j];
                if(map.containsKey(k)){
                    map.put(k,map.get(k)+1);
                }else{
                    map.put(k,1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                k=nums3[i]+nums4[j];
                if(map.containsKey(0-k)){
                    sum+=map.get(0-k);
                }
            }
        }
        return sum;
    }
}
