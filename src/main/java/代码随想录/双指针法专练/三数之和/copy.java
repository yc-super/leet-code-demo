package 代码随想录.双指针法专练.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class copy {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {-4,-1,-1,0,1,2};
        List<List<Integer>> lists = threeSum(nums);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new ArrayList<>();

        if(nums==null||nums.length<3){
            return result;
        }

        Arrays.sort(nums);
        int len=nums.length;
        int left,right;
        for (int i = 0; i < len; i++) {
            if(nums[i]>0)
                return result;

            if(i>0&&nums[i-1]==nums[i])
                continue;

            left=i+1;
            right=len-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else{
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    while(left<right&&nums[left+1]==nums[left]){
                        left++;
                    }while(left<right&&nums[right-1]==nums[right]){
                        right--;
                    }

                    left++;
                    right--;
                }

            }
        }
        return result;
    }
}
