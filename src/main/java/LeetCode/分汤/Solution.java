package LeetCode.分汤;

public class Solution {


    public static void main(String[] args) {
        int n = 100;
        System.out.println(new Solution().soupServings2(n));
    }


    private double result = 0;
    private static final double PROBABILITY = 0.25;
    //暴力搜索，超时了，吃了不熟悉动态规划的亏
    public double soupServings(int n) {
        method0(n, n, 0.25);
        return result;
    }

    private void method0(int sumA, int sumB, double pro) {
        int i = methodA(sumA, sumB, pro);
        if (i == 1) {
            method0(sumA - 100, sumB, pro * PROBABILITY);
        }
        int i1 = methodB(sumA, sumB, pro);
        if (i1 == 1) {
            method0(sumA - 75, sumB - 25, pro * PROBABILITY);
        }
        int i2 = methodC(sumA, sumB, pro);
        if (i2 == 1) {
            method0(sumA - 50, sumB - 50, pro * PROBABILITY);
        }
        int i3 = methodD(sumA, sumB, pro);
        if (i3 == 1) {
            method0(sumA - 25, sumB - 75, pro * PROBABILITY);
        }
    }

    private int methodA(int sumA, int sumB, double pro) {
        if (sumA - 100 <= 0&&sumB-0<=0) {
            result =result+ pro/2;
            return -1;
        }
        if (sumA - 100 <= 0) {
            result += pro;
            return -1;
        }
        if(sumB<=0){
            return 0;
        }
        return 1;
    }

    private int methodB(int sumA, int sumB, double pro) {
        if (sumA - 75 <= 0 && sumB - 25 <= 0) {
            result = result + pro / 2;
            return -1;
        }
        if (sumA - 75 <= 0) {
            result += pro;
            return -1;
        }
        if(sumB - 25 <= 0){
            return 0;
        }
        //A和B都没有分配完
        return 1;
    }

    private int methodC(int sumA, int sumB, double pro) {
        if (sumA - 50 <= 0 && sumB - 50 <= 0) {
            result = result + pro / 2;
            return -1;
        }
        if (sumA - 50 <= 0) {
            result += pro;
            return -1;
        }
        if(sumB - 50 <= 0){
            return 0;
        }
        //A和B都没有分配完
        return 1;
    }

    private int methodD(int sumA, int sumB, double pro) {
        if (sumA - 25 <= 0 && sumB - 75 <= 0) {
            result = result + pro / 2;
            return -1;
        }
        if (sumA - 25 <= 0) {
            result += pro;
            return -1;
        }
        if(sumB - 75 <= 0){
            return 0;
        }
        //A和B都没有分配完
        return 1;
    }


    //自己想到动态规划
    public double soupServings2(int n) {
        int nn;
        if(n%25==0){
            nn=n;
        }else{
            nn=(n/25+1)*25;
        }
        double[][] dp=new double[nn+1][nn+1];

//        for (int i = 0; i < nn + 1; i=i+25) {
//            for (int j = 0; j < nn+1; j=j+25) {
//                dp[i][j]=getMethodC(i,j,dp);
//            }
//        }
        return getMethodC(nn,nn,dp);


//        return dp[nn][nn];
    }

    //i和j可等可不等
    private double getMethodC(int i, int j, double[][] dp) {
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        double result=0;
        int tempI=i;
        int tempJ=j;

        //A需要100，B需要0
        tempI-=100;
        tempJ-=0;
        if(tempI<=0&&tempJ>0){
            result+=1;
        }else if(tempI<=0&&tempJ<=0) {
            result += 0.5;
        }else if(tempI>0&&tempJ<=0){
            result+=0;
        }else{
            //不属于上面3种情况，A先，一块，B先。说明还没分完
            result=result+(getMethodC(tempI,tempJ,dp));
        }

        tempI=i;
        tempJ=j;

        //A需要75，B需要25
        tempI-=75;
        tempJ-=25;
        if(tempI<=0&&tempJ>0){
            result+=1;
        }else if(tempI<=0&&tempJ<=0) {
            result += 0.5;
        }else if(tempI>0&&tempJ<=0){
            result+=0;
        }else{
            //不属于上面3种情况，A先，一块，B先。说明还没分完
            result=result+(getMethodC(tempI,tempJ,dp));
        }

        tempI=i;
        tempJ=j;

        //A需要50，B需要50
        tempI-=50;
        tempJ-=50;
        if(tempI<=0&&tempJ>0){
            result+=1;
        }else if(tempI<=0&&tempJ<=0) {
            result += 0.5;
        }else if(tempI>0&&tempJ<=0){
            result+=0;
        }else{
            //不属于上面3种情况，A先，一块，B先。说明还没分完
            result=result+(getMethodC(tempI,tempJ,dp));
        }

        tempI=i;
        tempJ=j;
        //A需要25，B需要75
        tempI-=25;
        tempJ-=75;
        if(tempI<=0&&tempJ>0){
            result+=1;
        }else if(tempI<=0&&tempJ<=0) {
            result += 0.5;
        }else if(tempI>0&&tempJ<=0){
            result+=0;
        }else{
            //不属于上面3种情况，A先，一块，B先。说明还没分完
            result=result+(getMethodC(tempI,tempJ,dp));
        }

        dp[i][j]=result*PROBABILITY;
        return dp[i][j];
    }

}
