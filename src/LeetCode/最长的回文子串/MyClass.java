package LeetCode.最长的回文子串;
/*
* 给你一个字符串 s，找到 s 中最长的回文子串。
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
*
* 输入：s = "cbbd"
输出："bb"
*
* 输入：s = "a"
输出："a"
*
* 输入：s = "ac"
输出："a"

 * */
public class MyClass {
    public static void main(String[] args) {
//        String s = "babad";
//        String s = "a";
//        String s = "ac";
//        String s = "cbbd";
//        String s = "cbaab";
        String s = "cbaabfkf";
        System.out.println(longestPalindrome(s));
    }
    /*
    * 最先想到的是暴力解法：
    * 遍历s,假设s[i]是回文中心，然后遍历s[i]的左右两边，当左右两边不等时，结束遍历，得到以s[i]为中心的回文子串长度
    * */
    public static String longestPalindrome(String s) {
        StringBuilder maxString=new StringBuilder();
        char[] cs = s.toCharArray();
        int index;//偏移量
        int maxIndex=0;//最大偏移量
        int maxCenter=0;
        int maxCenter2=-1;
        for (int i = 0; i < cs.length; i++) {
            index=1;
            while(i-index>=0&&i+index<cs.length){
                if(cs[i-index]==cs[i+index]){
                    index++;
                }else{
                    break;
                }
            }
            index--;
            if(index>maxIndex){
                maxIndex=index;
                maxCenter=i;
            }
        }
        //cbbd,cbaab
        boolean flag=false;
        for (int i = 0; i < cs.length; i++) {
            index=0;
            while(i-index>=0&&i+index+1<cs.length){
                if(cs[i-index]==cs[i+index+1]){
                    index++;
                    maxCenter2=i;
                }else{
                    break;
                }
            }
            index--;
            if(2*(index+1)>2*maxIndex+1){
                maxIndex=index;
                maxCenter=i;
                flag=true;
            }
        }

        if(maxIndex==0){
            if(maxCenter2>-1) {
                for (int i = maxCenter2 - maxIndex; i <= maxCenter2 + maxIndex + 1; i++) {
                    maxString.append(cs[i]);
                }
            }else{
                return String.valueOf(cs[0]);
            }
        }else if(flag){
            for (int i = maxCenter - maxIndex; i <= maxCenter + maxIndex+1; i++) {
                maxString.append(cs[i]);
            }
        }else {
            for (int i = maxCenter - maxIndex; i <= maxCenter + maxIndex; i++) {
                maxString.append(cs[i]);
            }
        }
        return maxString.toString();
    }
}
