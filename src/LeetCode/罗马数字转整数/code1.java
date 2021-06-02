package LeetCode.罗马数字转整数;

public class code1 {
    public static void main(String[] args) {
        String s="MCMXCIV";
        int result = romanToInt(s);
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        int result=0;
        int i;
        for(i=0;i<s.length();i++){
            if(i<s.length()-1&&compare(s,i)<0){
                result-=returnResult(s.charAt(i));
            }else{
                result+=returnResult(s.charAt(i));
            }
        }
        return result;
    }
    //比较s的第i个字符与第i+1个字符的大小
    public static int compare(String s,int i){
        return returnResult(s.charAt(i))-returnResult(s.charAt(i+1));
    }
    public static int returnResult(char s){
        if(s=='I')
            return 1;
        if(s=='V')
            return 5;
        if(s=='X')
            return 10;
        if(s=='L')
            return 50;
        if(s=='C')
            return 100;
        if(s=='D')
            return 500;
        if(s=='M')
            return 1000;
        return 0;
    }
}
