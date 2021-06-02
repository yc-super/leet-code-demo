package LeetCode.罗马数字转整数;
/*
*
* 字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*
*
* I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
C可以放在D(500) 和M(1000) 的左边，来表示400 和900。

* 输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
*
* LVIV
*/
public class MyClass {
    public static void main(String[] args) {
        String s="MCMXCIV";
        int result = romanToInt(s);
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        int result=0;
        int i;
        for(i=0;i<s.length();i++){
            if(i+1<s.length()&&compare(s,i)<0){
                result+=returnResult(s.substring(i,i+2));
                i++;
            }else{
                result+=returnResult(String.valueOf(s.charAt(i)));
            }
        }
        return result;
    }
    //比较s的第i个字符与第i+1个字符的大小
    public static int compare(String s,int i){
        return returnResult(String.valueOf(s.charAt(i)))-returnResult(String.valueOf(s.charAt(i+1)));
    }
    public static int returnResult(String s){
        if(s.equals("I"))
            return 1;
        if(s.equals("V"))
            return 5;
        if(s.equals("X"))
            return 10;
        if(s.equals("L"))
            return 50;
        if(s.equals("C"))
            return 100;
        if(s.equals("D"))
            return 500;
        if(s.equals("M"))
            return 1000;

        if(s.equals("IV"))
            return 4;
        if(s.equals("IX"))
            return 9;
        if(s.equals("XL"))
            return 40;
        if(s.equals("XC"))
            return 90;
        if(s.equals("CD"))
            return 400;
        if(s.equals("CM"))
            return 900;
        return 0;
    }
}
