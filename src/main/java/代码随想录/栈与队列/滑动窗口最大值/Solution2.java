package 代码随想录.栈与队列.滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public static void main(String[] args) {
//        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] nums={1,3,-1,2,-1,-1,-1};//{3,4}
        int k=3;
        int[] result = new Solution2().maxSlidingWindow(nums, k);
        for(int num:result){
            System.out.println(num);
        }
    }

    class MyQueue{
        private Deque<Integer> deque=new ArrayDeque<>();
        public void poll(int val){
            if(!deque.isEmpty()&&deque.peek()==val){
                deque.poll();
            }
        }
        public void add(int val){
            while(!deque.isEmpty()&&deque.getLast()<=val){
                deque.removeLast();
            }
            deque.offer(val);
        }
        public int top(){
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1)
            return nums;

        MyQueue myQueue = new MyQueue();
        int[] result=new int[nums.length-k+1];
        int i = 0;
        for (; i < k; i++) {
            myQueue.add(nums[i]);
        }

        for (; i < nums.length; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
        }

        return result;
    }
}
