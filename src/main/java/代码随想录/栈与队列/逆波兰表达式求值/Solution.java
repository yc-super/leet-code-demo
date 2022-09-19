package 代码随想录.栈与队列.逆波兰表达式求值;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque=new ArrayDeque<>();
        for(String token:tokens){
            if(token.equals("+")){
                Integer num1 = deque.pop();
                Integer num2 = deque.pop();
                deque.push(num2+num1);
            }else if(token.equals("-")){
                Integer num1 = deque.pop();
                Integer num2 = deque.pop();
                deque.push(num2-num1);
            }else if(token.equals("*")){
                Integer num1 = deque.pop();
                Integer num2 = deque.pop();
                deque.push(num2*num1);
            }else if(token.equals("/")){
                Integer num1 = deque.pop();
                Integer num2 = deque.pop();
                deque.push(num2/num1);
            }else{
                Integer num = Integer.valueOf(token);
                deque.push(num);
            }
        }
        return deque.pop();
    }

    public static void main(String[] args) {
//        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        String[] tokens = {"4","13","5","/","+"};
//        String[] tokens = {"2","1","+","3","*"};
        String[] tokens = {"2","1","-"};
        System.out.println(evalRPN(tokens));
    }
}
