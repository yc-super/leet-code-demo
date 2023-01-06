package 代码随想录.贪心算法.买卖股票的最佳时机含手续费;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new Solution().maxProfit(prices, fee));
    }

    //自己想的，感觉是没什么问题，但是一个比较复杂的测试用例没有通过。
    //很烦这种情况，不知道哪儿的问题，还不能通过测试用来来找到问题
    public int maxProfit(int[] prices, int fee) {
        int preStart = prices[0];
        int preHigh = prices[0];
        int curStart = 0;
        int curHigh = 0;
        int sum = 0;//记录最终结果
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                //找到了上升趋势的第一个点，该点为curStart
                curStart = prices[i - 1];
                //接下来找该点对应的上升趋势的最高点
                int index = i;
                while (index < prices.length && prices[index] > prices[index - 1]) {
                    index++;
                }
                curHigh = prices[index - 1];
                if (curStart >= preStart) {
                    if (curHigh - curStart - fee >= curHigh - preHigh) {
                        //分批买卖，将上一个最低最高点买卖
                        sum += Math.max(preHigh - preStart - fee, 0);
                        preHigh = curHigh;
                        preStart = curStart;
                    } else {
                        //将两次买卖合为一次，暂时不进行交易
                        preHigh = curHigh;
                    }
                } else {
                    //当前最低点小于上一个最低点，不能和上一次一块买卖，将上一个最低最高点进行交易
                    sum += Math.max(preHigh - preStart - fee, 0);
                    preHigh = curHigh;
                    preStart = curStart;
                }
                i = index - 1;
            }
        }
        //将最后一组最低最高点进行交易
        sum += Math.max(preHigh - preStart - fee, 0);
        return sum;
    }

    //
    public int maxProfit2(int[] prices, int fee) {
        int minPrice = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];//相当于买入
            }
            if (prices[i] > minPrice + fee) {
                //卖出，可能多次卖出，有的是假卖出
                sum += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee;//如果后面出现继续买的情况，那么最低点相当于是prices[i]了，提前减去fee，避免重复加
            }
        }
        return sum;
    }
}
