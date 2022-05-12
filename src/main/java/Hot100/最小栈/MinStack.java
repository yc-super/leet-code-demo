package Hot100.最小栈;

public class MinStack {
    private int minVal=Integer.MAX_VALUE;
    public MinStack() {

    }

    public void push(int val) {
        if(val<minVal)
            minVal=val;

    }

    public void pop() {

    }

    public int top() {

    }

    public int getMin() {
        return this.minVal;
    }
}
