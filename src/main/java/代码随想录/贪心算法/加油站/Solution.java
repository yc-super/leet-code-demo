package 代码随想录.贪心算法.加油站;

public class Solution {
    public static void main(String[] args) {
//        int[] gas={1,2,3,4,5};
//        int[] cost={3,4,5,1,2};
//        int[] gas={2,3,4};
//        int[] cost={3,4,3};
//        int[] gas = {5,2,4,4,5,1};
//        int[] cost = {3,3,1,9,1,4};
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};
        int[] gas = {4, 5, 2, 6, 5, 3};
        int[] cost = {3, 2, 7, 3, 2, 9};
        //1,-3,1,-2,3
        //2,-1,3,-6,4,-3
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }

    //我自己想的贪心，虽然优化了很多，但代码有点冗余，导致效率不高
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = gas[i] - cost[i];
        }
        int count;
        int next;
        for (int i = 0; i < len; i++) {
            if (temp[i] < 0)
                continue;
            if (i != 0 && temp[i - 1] >= 0) {
                continue;
            }
            if (i == len - 1)
                next = 0;
            else
                next = i + 1;
            count = temp[i];
            while (next != i) {
                count += temp[next];
                if (count < 0) {
//                    if (i == len - 1)
//                        return -1;
                    if (i < next)
                        i = next ;
                    break;
                }
                if (next == len - 1)
                    next = 0;
                else
                    next++;
            }
            if (count >= 0)
                return i;
        }
        return -1;
    }

    //代码随想录 贪心，效率高多了。感觉关键点是用一个totalCount来确保一定可以走一圈/一定走不完一圈
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalCount=0;
        int curCount=0;
        int index=0;
        for (int i = 0; i < gas.length; i++) {
            totalCount+=gas[i]-cost[i];
            curCount+=gas[i]-cost[i];
            if(curCount<0){
                index=i+1;
                curCount=0;
            }
        }
        if(totalCount<0)
            return -1;
        return index%gas.length;
    }
}
