package Hot100.下一个排列;

import static jdk.nashorn.internal.objects.NativeArray.sort;

public class MyCode {
    /*
    * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
* 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，
* 那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。

必须 原地 修改，只允许使用额外常数空间。
*
*
* 1234  1243    1324    1342    1423  1432   2134
* 13542 14532   14235
* 54321
    * */
    public static void main(String[] args) {
        //int[] nums={1,3,5,4,2};
        int[] nums={3,2,1,1};
        new MyCode().nextPermutation(nums);
        System.out.println();
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length-1;
        int i,j;
        for (i=n; i >=1; i--) {
            if(nums[i-1]<nums[i])
                break;
        }
        i--;
        if(i>=0){
            for (j = n; j >i ; j--) {
                if(nums[j]>nums[i]){
                    break;
                }
            }
            swap(i,j,nums);
        }
        sortArr(i+1,nums);
    }

    private void sortArr(int start, int[] nums) {
        int l=start,r=nums.length-1;
        while(l<r){
            swap(l,r,nums);
            l++;
            r--;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int index=nums[i];
        nums[i]=nums[j];
        nums[j]=index;
    }

    /*
    *我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。

同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。

    * 以排列 [4,5,2,6,3,1][4,5,2,6,3,1] 为例：

我们能找到的符合条件的一对「较小数」与「较大数」的组合为 22 与 33，满足「较小数」尽量靠右，而「较大数」尽可能小。

当我们完成交换后排列变为 [4,5,3,6,2,1][4,5,3,6,2,1]，此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6][4,5,3,1,2,6]。

具体地，我们这样描述该算法，对于长度为 nn 的排列 aa：

首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)，满足 a[i] < a[i+1]a[i]<a[i+1]。这样「较小数」即为 a[i]a[i]。此时 [i+1,n)[i+1,n) 必然是下降序列。

如果找到了顺序对，那么在区间 [i+1,n)[i+1,n) 中从后向前查找第一个元素 jj 满足 a[i] < a[j]a[i]<a[j]。这样「较大数」即为 a[j]a[j]。

交换 a[i]a[i] 与 a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
    * */
}
