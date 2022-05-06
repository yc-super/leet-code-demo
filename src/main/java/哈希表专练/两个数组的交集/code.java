package 哈希表专练.两个数组的交集;

import java.util.*;

public class code {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result=new code().intersection(nums1,nums2);
        for(int a :result){
            System.out.print(a+",");
        }
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0)
            return null;
        Set<Integer> set=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        Integer value;
        for(int a:nums1){
            set.add(a);
        }
        for(int a:nums2){
            if(set.contains(a)){
                set2.add(a);
            }
        }

        int[] array=new int[set2.size()];
        int index=0;
        for(int i:set2){
            array[index++]=i;
        }
        return array;
    }
}
