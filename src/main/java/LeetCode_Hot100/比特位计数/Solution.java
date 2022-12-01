package LeetCode_Hot100.比特位计数;

public class Solution {
    public int[] countBits(int n) {
        if(n==0)
            return new int[]{0};
        int[] result=new int[n+1];
        result[0]=0;
        for (int i = 1; i <= n; i++) {
            if(i%2==0){
                result[i]=result[i/2];
            }else{
                result[i]=result[i/2]+1;
            }
        }
        return result;
    }
}
