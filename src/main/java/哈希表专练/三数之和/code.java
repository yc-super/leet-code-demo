package 哈希表专练.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code {
    public static void main(String[] args) {
        int[] nums=new int[]{-3,-3,-1,-1,-1,-1,0,1,2,2,2};
//        int[] nums=new int[]{0};
        List<List<Integer>> lists=new code().threeSum(nums);
        for(List<Integer> list:lists){
            for(Integer i:list){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
    List<List<Integer>> lists=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        //-1,0,1,2,-1,-4
        //-4,-1,-1,0,1,2
        Arrays.sort(nums);
//        backTrack(0,nums,new ArrayList<Integer>(),0);
        int len=nums.length;
        int l,r;
        for (int i = 0; i < len-2&&nums[i]<=0; i++) {
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            l=i+1;
            r=len-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]<0){
                    break;
                }else if(nums[i]+nums[l]+nums[r]==0){
                    lists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    while(nums[l]==nums[l-1]&&l<r){
                        l++;
                    }
                    r--;
                    while(nums[r]==nums[r+1]&&l<r){
                        r--;
                    }
                }else{
                    r--;
                }
            }
        }
        return lists;
    }


    private void backTrack(int start, int[] nums, ArrayList<Integer> list,int sum) {

    }
}
