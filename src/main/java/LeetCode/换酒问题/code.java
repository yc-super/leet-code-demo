package LeetCode.换酒问题;

public class code {
    public static void main(String[] args) {
        int numBottles = 3, numExchange = 2;
        System.out.println(new code().numWaterBottles(numBottles,numExchange));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int num=numBottles;
       while(numBottles/numExchange!=0){
           num+=numBottles/numExchange;
           numBottles=(numBottles/numExchange)+numBottles%numExchange;
       }
       return num;
    }
}
