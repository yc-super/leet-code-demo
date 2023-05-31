package 代码随想录.单调栈.下一个更大元素I;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int[] nums1 = {1,3,5,2,4};
        int[] nums1 = {1,2,5,3,4};
        int[] nums2 = {5,3,4,1,2};
        System.out.println(new Solution().nextGreaterElement2(nums1,nums2));
    }

    //单调栈+哈希映射。
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] result3 = new int[10001];
        for (int i = 0; i < len2; i++) {
            result3[nums2[i]] = i;
        }

        int[] result = new int[len2];
        for (int i = 0; i < len2; i++) {
            result[i] = -1;
        }

        Deque<Integer> deque = new LinkedList();
        deque.push(0);
        for (int i = 1; i < len2; i++) {
            while (!deque.isEmpty() && nums2[deque.peek()] < nums2[i]) {
                result[deque.pop()] = nums2[i];
            }
            deque.push(i);
        }

        int[] result2 = new int[len1];
        for (int i = 0; i < len1; i++) {
            result2[i] = result[result3[nums1[i]]];
        }
        return result2;
    }

    //上面的方法中，其实可以不必求出nums2中每个元素右边第一个比它大的值的，只求nums1中的就行了
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] result = new int[len1];
        Arrays.fill(result,-1);//初始化为-1
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i],i);
        }
        Deque<Integer> deque=new LinkedList<>();
        deque.push(0);
        for (int i = 1; i < len2; i++) {
            while(!deque.isEmpty()&&nums2[deque.peek()]<nums2[i]){
                if(map.containsKey(nums2[deque.peek()])) {
                    result[map.get(nums2[deque.peek()])] = nums2[i];
                }
                deque.poll();
            }
            deque.push(i);
        }
        return result;
    }
}
