package LeetCode.最长公共前缀;
/*
* 输入：strs = ["flower","flow","flight"]
输出："fl"
*
* 输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀
*
* */
public class MyClass {
    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"flower","dog","cat"};
        String result=longestCommonPrefix(strs);
        System.out.println(result);

        //也可以利用startWith()方法解题，可以返回字符串是否以字符串开头，返回类型boolean
        System.out.println("abc".startsWith("ac"));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length<=0){
            return "";
        }
        if(strs.length==1)
            return strs[0];

        StringBuilder sb=new StringBuilder();
        char a='0';
        int minLength=200;
        int j=0;
        for (int i = 0; i < strs.length; i++) {
            minLength=Math.min(strs[i].length(),minLength);
        }
        while(j<minLength){
            for (int i = 0; i < strs.length; i++) {
                if(i==0){
                    a=strs[i].charAt(j);
                }else{
                    if(a!=strs[i].charAt(j)){
                        return sb.toString();
                    }else{
                        if(i+1==strs.length)
                            sb.append(a);
                    }
                }
            }
            j++;
        }

        return sb.toString();
    }
}
