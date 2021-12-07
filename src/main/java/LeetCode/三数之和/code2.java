package LeetCode.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//官方答案，排序+双指针
public class code2 {
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};//-4,-1,-1,0,1,2
        int[] nums = {-4,-1,-1,0,1,2};//-4,-1,-1,0,1,2
        List<List<Integer>> l=new code2().threeSum(nums);
        for(List<Integer> list:l){
            System.out.println(list);
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int l,r,index;
        for (int i = 0; i <nums.length-1&&nums[i]<=0; i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            l=i+1;
            r=nums.length-1;
            while(l<r){
                index=nums[i]+nums[l]+nums[r];
                if(index==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    do {
                        l++;
                    }while(nums[l]==nums[l-1]&&l<r);
                }else if(index>0){
                    do {
                        r--;
                    }while(nums[r]==nums[r+1]&&l<r);
                }else{
                    do {
                        l++;
                    }while(nums[l]==nums[l-1]&&l<r);
                }
            }
        }
        return result;
    }
}
