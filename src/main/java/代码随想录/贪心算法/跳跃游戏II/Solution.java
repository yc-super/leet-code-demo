package 代码随想录.贪心算法.跳跃游戏II;

public class Solution {
    //贪心，从当前节点往后可能有多种选择，那么选哪一个呢，从这些可选项中选择i+nums[i]最大的那个，因为这个往后的范围大于其他的，其他的能做到它也能做到
    //注意题目中明确说了测试用例全部都可以到达最后一个下标
    //2,3,1,1,4
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        int count=0;
        int len=nums.length;
        int[] temp=new int[len];
        for (int i = 0; i < len; i++) {
            temp[i]=i+nums[i];
        }
        int maxIndex;
        for (int i = 0; i < len; ) {
            if(temp[i]>=len-1){
                return ++count;
            }
            maxIndex=i+1;
            for (int j = maxIndex+1; j <=temp[i]; j++) {
                if(temp[j]>temp[maxIndex]){
                    maxIndex=j;
                }
            }
            i=maxIndex;
            count++;
        }
        return count;
    }
}
