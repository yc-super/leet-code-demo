package Hot100.最小栈.官方答案2;

import java.util.Deque;
import java.util.LinkedList;

public class MinStackCopy {
    public static void main(String[] args) {

    }
    private int min;
    private Deque<Long> stack;

    public MinStackCopy() {
        stack=new LinkedList<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min=val;
        }else{
            stack.push(Long.valueOf(val) - min);
            min=Math.min(min,val);
        }
    }

    public void pop() {
        Long diff = stack.pop();
        if(diff>=0){
            //return diff+min;//大于0说明实际值比min大，不用更新min值
        }else{//实际值-上一个min=现在stack里的值(也就是diff)
//            int res=min;
            min=(int)(min-diff);
            //return res;
        }

    }

    public int top() {
        Long diff = stack.peek();
        if(diff>=0){
            return (int)(diff+min);
        }else{
            return min;
        }
    }

    public int getMin() {
        return min;
    }
}
