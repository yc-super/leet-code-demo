package 剑指offer.验证图书取出顺序;

import java.util.Stack;

public class Solution {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        if(putIn==null||putIn.length==0)
            return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(1000);
        int index=-1;
        for (int a : takeOut) {
            while (stack.peek() != a) {
                if (++index == putIn.length)
                    return false;
                stack.push(putIn[index]);
            }
            stack.pop();
            if (stack.empty())
                return false;
        }
        return stack.size()==1;
    }
}
