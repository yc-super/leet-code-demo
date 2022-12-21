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
}
