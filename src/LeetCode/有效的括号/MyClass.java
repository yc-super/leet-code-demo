package LeetCode.有效的括号;
/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
*
* 输入：s = "()[]{}"
输出：true
*
* 输入：s = "(]"
输出：false
*
* 输入：s = "([)]"
输出：false
*
* 输入：s = "{[]}"
输出：true
*
* 注意：
* 1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
* */
public class MyClass {
    public static void main(String[] args) {
//        String s = "([)]";
        String s = "(}";
//        String s = "{[]}";
//        String s = "{[}]";
//        String s = "{[]{}({})}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if(!(s.charAt(0)=='('||s.charAt(0)=='['||s.charAt(0)=='{'))
            return false;
        char[] c = s.toCharArray();
        int num1=0;//记录(的个数
        int num2=0;//记录[的个数
        int num3=0;//记录{的个数
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                num1++;
            }else if(s.charAt(i)=='['){
                num2++;
            }else if(s.charAt(i)=='{'){
                num3++;
            }else if(s.charAt(i)==')'){
                int index=preStr(c,i);
                if(index==-1||c[index]!='(')
                    return false;
                num1--;
                if(num1<0)
                    return false;
                c[index]='0';
                c[i]='0';
            }else if(s.charAt(i)==']'){
                int index=preStr(c,i);
                if(index==-1||c[index]!='[')
                    return false;
                num2--;
                if(num2<0)
                    return false;
                c[index]='0';
                c[i]='0';
            }else if(s.charAt(i)=='}'){
                int index=preStr(c,i);
                if(index==-1||c[index]!='{')
                    return false;
                num3--;
                if(num3<0)
                    return false;
                c[index]='0';
                c[i]='0';
            }
        }
        return num1==0&&num2==0&&num3==0;
    }
    private static int preStr(char[] c,int index){
        for (int i = index-1; i >=0; i--) {
            if(c[i]!='0')
                return i;
        }
        return -1;
    }
}
