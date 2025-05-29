package 宫水三叶.查找和最小的K对数字;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 3, 3};
        int[] nums2 = {1, 5, 6};
        int k = 3;
        List<List<Integer>> lists = new Solution().kSmallestPairs(nums1, nums2, nums1.length * nums2.length);
        System.out.println();
    }

    // 灵神的题解
    public List<List<Integer>> kSmallestPairs111(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result=new ArrayList<>(k);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        priorityQueue.add(new int[]{nums1[0]+nums2[0],0,0});

        while(result.size()<k){
            int[] poll = priorityQueue.poll();
            List<Integer> ll=new ArrayList<>();
            int i=poll[1];
            int j=poll[2];
            ll.add(i);
            ll.add(j);
            result.add(ll);

            if(poll[2]==0&&i+1<nums1.length){
                priorityQueue.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
            }

            if(j+1<nums2.length) {
                priorityQueue.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return result;
    }

    /*
     * 112233
     * 156
     * */
    // 自己写的，内存挺好，时间太慢
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[] num = new int[nums1.length];
        int preIndex = 0;
        int rightIndex = 0;

        List<List<Integer>> result = new ArrayList<>(k);
        while (result.size() != k) {
            int min = Integer.MAX_VALUE;
            int minIndex = preIndex;
            if (num[rightIndex] != 0 && rightIndex < nums1.length - 1) {
                rightIndex++;
            }
            for (int i = preIndex; i <= rightIndex; i++) {
                if (i != preIndex && nums1[i] == nums1[i - 1] && num[i - 1] == num[i]) {
                    continue;
                }
                min = Math.min(min, nums1[i] + nums2[num[i]]);
                if (nums1[i] + nums2[num[i]] <= min) {
                    min = nums1[i] + nums2[num[i]];
                    minIndex = i;
                }
            }
            List<Integer> ll = new ArrayList<>();
            ll.add(nums1[minIndex]);
            ll.add(nums2[num[minIndex]]);
            result.add(ll);
            if (num[minIndex] < nums2.length - 1) {
                num[minIndex]++;
            } else {
                preIndex++;
            }
        }
        return result;

    }


    // 小顶堆。没写完。不用想了，没有利用数组有序性，肯定效率很低
    public List<List<Integer>> kSmallestPairs11(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>(k);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        Map<Integer, List<int[]>> map=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if(map.containsKey(sum)){
                    int[] ints = {nums1[i], nums2[j]};
                    map.get(sum).add(ints);
                }else{
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[]{nums1[i], nums2[j]});
                    map.put(sum,list);
                }
                priorityQueue.add(sum);
            }
        }
        return result;
    }



    // 自己写的，没有通过，考虑不全
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        // nums1长度为1，需要特别处理
        int pre = 0, next = 1;
        int preIndex = 0, nextIndex = 0;
        List<List<Integer>> result = new ArrayList<>(k);
        while (result.size() != k) {
            if (preIndex == nums2.length) {
                pre = next;
                preIndex = nextIndex;
                next = pre + 1;
                nextIndex = 0;
            }
            if (nums1[pre] + nums2[preIndex] <= nums1[next] + nums2[nextIndex]) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[pre]);
                list.add(nums2[preIndex]);
                result.add(list);
                preIndex++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[next]);
                list.add(nums2[nextIndex]);
                result.add(list);
                nextIndex++;
            }
        }
        return result;
    }
}
