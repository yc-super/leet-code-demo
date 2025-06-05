package 灵神.第k大第k小题单.两个有序数组的第K小乘积;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4};
        int[] nums2 = {2, 3, 4};
        long k = 1;
        System.out.println(new Solution().kthSmallestProduct(nums1, nums2, k));
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "自定义线程池名称");
            }
        };
        new LinkedBlockingQueue<>(100);
        new ArrayBlockingQueue<>(100);
        DelayQueue<Delayed> delayeds1 = new DelayQueue<>();
        delayeds1.add(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        });
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        },new ThreadPoolExecutor.AbortPolicy());
        ScheduledFuture<?> f1 = scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(123);
            }
        }, 1, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.schedule(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        },1,TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.getQueue().size();
        DelayQueue<Delayed> delayeds = new DelayQueue<>();
    }

    // -3,-2,-1 2,3,4
    // -5,-4,-2 5,6,7
    /*
     * 负正    负   正
     * 负正    负   正
     * */


    // 第k大/小经典题目，只不过要分类讨论而已需要找到负数下标范围，0范围，正数下标范围。
    // 二分法
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        //3种情况：正正（左左）、负负（右右）、其他情况（左右）
        int n1 = nums1.length, n2 = nums2.length;
        // 正正
        if (nums1[0] >= 0 && nums2[0] >= 0) {
            // 优先队列没法用了，因为优先队列的compare方法返回类型是int。只能用二分法
            long left = (long) nums1[0] * nums2[0], right = (long) nums1[n1 - 1] * nums2[n2 - 1];
            while (left < right) {
                long count = 0;
                long middle = (left + right) >> 1;
                // 找到nums1中最大下标，该下标乘以nums2[0]刚好大于等于middle
                int index = getMaxIndexFromNums1(middle, nums2[0], nums1);
                for (int i = 0; i < index; i++) {
//                    int cnt = getCount(i, nums1, nums2, middle);
//                    count += cnt;

                    int cnt = getMaxIndexFromNums1(middle, nums1[i], nums2);
                    count += cnt + 1;
                }
                if (k > count) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            return left;// 如何保证left一定是某个nums1[i]*nums2[j]的值：因为其中的二分法是lower_bound的，会不断往左移，直到最左边第一个符合条件的值
        } else if (nums1[n1 - 1] <= 0 && nums2[n2 - 1] <= 0) {// 负负

        } else {// 其他

        }
        return 0;
    }

    // 寻找第一个小于等于target的值
    private int getMaxIndexFromNums1(long target, int num, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) >> 1;
            long l = (long) nums[middle] * num;
            if (target > l) {
                left = middle + 1;
            } else {
                right = middle;
            }
//            else {
//                return right;
//            }
        }
//        // left下标大于等于target
//        long l = (long) nums[left] * num;
//        if(target<l){
//            left--;
//        }
        return left;
//        return right;
    }
}
