package 代码随想录.栈与队列.滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;

//构建一个双端队列
public class Solution3 {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] ints = new Solution3().maxSlidingWindow(nums, 3);
        System.out.println();
    }
    class MyDeque {
        private Deque<Integer> deque;

        MyDeque() {
            deque = new LinkedList<>();
        }

        public void add(int x) {
            while (!deque.isEmpty() && x > deque.peekLast()) {
                deque.removeLast();
            }
            deque.add(x);
        }

        public int pop(){
            return deque.removeFirst();
        }

        public int top(){
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyDeque deque=new MyDeque();
        int len=nums.length;
        int[] result=new int[len-k+1];
        int index=0;
        for (int i = 0; i < k; i++) {
            deque.add(nums[i]);
        }
        result[index++]=deque.top();
        for (int i = k; i<len; i++) {
            if(nums[i-k]==deque.top()){
                deque.pop();
            }
            deque.add(nums[i]);
            result[index++]=deque.top();
        }
        return result;
    }
}
