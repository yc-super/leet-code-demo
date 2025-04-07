package 剑指offer.交易逆序对的总数;

public class Solution {
    public static void main(String[] args) {
        int[] record = {233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004};
        int i = new Solution().reversePairs(record);
        System.out.println(i);
    }


    // 题解。归并排序，在归并排序过程中，出现左子数组的元素大于右子数组的元素时，result+=middle-leftIndex+1
    int result = 0;

    public int reversePairs(int[] record) {
        if (record == null || record.length < 2)
            return 0;
        int i = record.length - 1;
        method(record, 0, i);
        return result;
    }

    public void method(int[] record, int start, int end) {
        if (start >= end)
            return;

        int middle = (start + end) / 2;
        method(record, start, middle);
        method(record, middle + 1, end);

        int leftIndex = start, rightIndex = middle + 1;
        int[] arr = new int[end - start + 1];

        int i;
        for (i = start; i <= end; i++) {
            if (leftIndex > middle || rightIndex > end)
                break;
            if (record[leftIndex] > record[rightIndex]) {
                arr[i - start] = record[rightIndex];
                rightIndex++;
                result += middle - leftIndex + 1;// 主要是这里
            } else {
                arr[i - start] = record[leftIndex];
                leftIndex++;
            }
        }
        while (leftIndex <= middle) {
            arr[i - start] = record[leftIndex++];
            i++;
//            result+=end-middle;
        }
        while (rightIndex <= end) {
            arr[i - start] = record[rightIndex++];
            i++;
        }
        for (i = start; i <= end; i++) {
            record[i] = arr[i - start];
        }
    }
}
