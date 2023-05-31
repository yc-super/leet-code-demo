package 代码随想录.单调栈.接雨水;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height={4,2,0,3,2,5};
        System.out.println(new Solution().trap2(height));
    }
    //双指针.每个下标，找左边最高的，再找右边最高的，取两者最小值，如果比当前元素大就*1，就是当前下标所能存的水的数量，否则为0
    public int trap(int[] height) {
        int len=height.length;
        if(len<=2)
            return 0;
        int result=0;
        int[] left=new int[len];
        left[0]=0;
        for (int i = 1; i < len; i++) {
            left[i]=Math.max(left[i-1],height[i-1]);
        }
        int[] right=new int[len];
        right[len-1]=0;
        for (int i = len-2; i >=0 ; i--) {
            right[i]=Math.max(right[i+1],height[i+1]);
        }
        for (int i = 0; i < len; i++) {
            int a=Math.min(left[i],right[i]);
            if(a>height[i]){
                result=result+a-height[i];
            }
        }
        return result;
    }

    //单调栈。不太好想到，理解倒是好理解，就是代码实现过程中很可能出错
    public int trap2(int[] height){
        int size = height.length;

        if (size <= 2) return 0;

        // in the stack, we push the index of array
        // using height[] to access the real height
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int sum = 0;
        for (int index = 1; index < size; index++){
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]){
                stack.push(index);
            }else if (height[index] == height[stackTop]){
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            }else{
                //pop up all lower value
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) sum += hold;
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }

        return sum;
    }
}
