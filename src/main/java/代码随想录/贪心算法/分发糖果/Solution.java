package 代码随想录.贪心算法.分发糖果;

public class Solution {
    //思路：想象一个折线图。涉及到里面有重复数据的测试用例，太复杂了，放弃
    public int candy(int[] ratings) {
        //1,2,3,4,5,6,7,8,16,13,12,11,0,8,3
        //1 2 3 4 5 6 7 8 9  4  3  2  1 2 1 2 1

        //2,2,2,2,3,4,3
        //2 1 2 1 2 3 1         12
        //1 2 1 2 3 4 1         14

        //2,2,2,2,2,3
        //2 1 2 1 2 3       11
        //1 2 1 2 1 2       9

        //2,2,2,2,1,2,2,2,2,2,4,5,6,7,8,9
        //1 2 1 2 1 3 2     1
        //


        int len=ratings.length;
        if(len==1)
            return 1;
        int result=0;
        int begin=0;
        int end,index=1;
        int oneCount=0;
        while(ratings[index]<=ratings[index-1]){
            index++;
        }
        begin=index-1;
        oneCount++;
        while(index<len&&ratings[index]>ratings[index-1]){
            index++;
        }
        int i=index;
        index--;
        while(i<len){
            while(i<len&&ratings[i]<ratings[i-1]){
                i++;
            }
            end=i-1;
            oneCount++;
            int x1=index-begin;
            int x2=end-index;
            if(x1>=x2)
                x1++;
            else
                x2++;
            result+=fix(x1);
            result+=fix(x2);
            begin=end;
            while(i<len&&ratings[i]>ratings[i-1]){
                i++;
            }
            index=i-1;
        }
        if(oneCount>2)
            oneCount-=2;
        return result-oneCount;
    }

    private int fix(int x) {
        return (x*(x+1))/2;
    }

    //代码随想录：先从前往后，只要右边孩子比左边大，就在左边孩子的基础上+1,否则置为1 -----保证右边孩子只要分数比左边大，那么右边一定比左边得到的糖果多
//然后从后向前，只要左边比右边孩子大，Max(在右边孩子的基础上+1，原先的值）------------在刚才的基础上，保证左边孩子只要比右边大，左边一定比右边得到的糖果多
    //真的巧妙啊，主要是分成了两次贪心。以后遇到这种两个维度的，先从一个维度考虑，看有没有突破点，记得从小到大和从大到小都试下
    public int candy2(int[] ratings) {
        int len=ratings.length;
        int[] temp=new int[len];
        temp[0]=1;
        for (int i = 1; i < len; i++) {
            if(ratings[i]>ratings[i-1]){
                temp[i]=temp[i-1]+1;
            }else{
                temp[i]=1;
            }
        }
        for (int i = len-2; i >=0; i--) {
            if(ratings[i]>ratings[i+1]){
                temp[i]=Math.max(temp[i],temp[i+1]+1);
            }
        }
        int result=0;
        for (int i = 0; i < len; i++) {
            result+=temp[i];
        }
        return result;
    }
}
