package 代码随想录.贪心算法.买卖股票的最佳时机II;

public class Solution {
    public static void main(String[] args) {
//        int[] prices={7,1,5,3,6,4};
//        int[] prices={1,2,6,4,3,5};
        int[] prices={3,2,1};
        System.out.println(new Solution().maxProfit(prices));
    }
    //思路：贪心，想象一个折线图，只取有上升趋势的一部分，所有上升趋势的折线最高点减最低点的差值的和就是结果
    public int maxProfit(int[] prices) {
        int left=0;
        int result=0;
        int i;
        for (i = 0; i < prices.length-1; i++) {
            if(prices[i+1]<prices[i]) {
                result=result+(prices[i]-prices[left]);
                left=i+1;
            }
        }
        if(i==prices.length-1){
            if(prices[i]>prices[left]){
                result=result+(prices[i]-prices[left]);
            }
        }
//        System.out.println(left);
        return result;
    }

    //代码随想录，贪心，每天都和前一天计算下利润（当然有的可能为负利润），把所有正利润相加就是最终结果
    public int maxProfit2(int[] prices) {
        int result=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                result+=(prices[i]-prices[i-1]);
            }
        }
        return result;
    }
}
