package 代码随想录.哈希表专练.两个数组的交集;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class code1 {
    public static void main(String[] args) {
        int[] nums1={2,2,3,4};
        int[] nums2={2,2,3,4,6};
        intersection(nums1,nums2);
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set= new HashSet<>();
        Set<Integer> result= new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }

//        int[] ints = result.stream().mapToInt(x -> x).toArray();

        int[] array=new int[result.size()];
        int index=0;
        for(int a:result){
            array[index++]=a;
        }
        return array;
    }
}
