package 代码随想录.双指针法专练.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
//        int[] nums={1,0,-1,0,-2,2};
//        int[] nums={2,2,2,2,2};
        int[] nums={-3,-2,-1,0,0,1,2,3};
//        int[] nums={0,0,0,0};
//        int[] nums={-2,-1,0,0,1,2};
        int target=0;
        List<List<Integer>> lists = fourSum(nums, target);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length<4){
            return result;
        }

        int len=nums.length;
        Arrays.sort(nums);

        int left,right;
        long sum=0;

        for (int i = 0; i < len-3; i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            for (int j = i+1; j < len-2; j++) {
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                left=j+1;
                right=len-1;
                while(left<right) {
                    sum=0;
                    sum+=nums[i];
                    sum+=nums[j];
                    sum+=nums[left];
                    sum+=nums[right];
                    if (sum < target) {
                        left++;
                    }else if(sum>target){
                        right--;
                    }else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right&&nums[left+1]==nums[left]){
                            left++;
                        }
                        while(left<right&&nums[right-1]==nums[right]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
