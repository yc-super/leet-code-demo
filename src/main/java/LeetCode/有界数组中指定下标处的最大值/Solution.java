package LeetCode.有界数组中指定下标处的最大值;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(7, 0, 930041194));
    }
    //0,0,0,0
    public int maxValue(int n, int index, int maxSum) {
        long sum=0;
        int llen=index,rlen=n-index-1;
        int l=1,r=maxSum,m;
        while(l<=r){
            m=(l+r)/2;
            sum=m;
            sum+=helper(llen,rlen,m);
            if(sum>maxSum){
                r=--m;
            }else{
                l=++m;
            }
        }
        return l-1;
    }

    private long helper(long llen, long rlen, long m) {
        long sum=0;
        m--;
        if(llen>0){
            if(llen>=m){
                sum+=(m*(m+1))/2;
                sum+=llen-m;
            }else{
//                int left=m-llen+1;
//                int right=m;
                sum+=(m*2-llen+1)*(llen/2);
                if(llen%2==1){
                    sum+=(m*2-llen+1)/2;
                }
            }
        }
        if(rlen>0){
            if(rlen>=m){
                sum+=(m*(m+1))/2;
                sum+=rlen-m;
            }else{
//                int left=m-llen+1;
//                int right=m;
                sum+=(m*2-rlen+1)*(rlen/2);
                if(rlen%2==1){
                    sum+=(m*2-rlen+1)/2;
                }
            }
        }
        return sum;
    }
}
