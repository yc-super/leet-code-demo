package LeetCode.无重复字符的最长子串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyCode {
    public static void main(String[] args) {
        String s=" ";
        int result=lengthOfLongestSubstring3(s);
        System.out.println(result);
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.equals(""))
            return 0;
        List<Character> list = new ArrayList();
        int result=0;
        int a=-1;//左指针
        for (int i = 0; i < s.length(); i++) {
            if(list.contains(s.charAt(i))){
                result=Math.max(result,list.size());
                list.clear();
                list.add(s.charAt(i));
                for (int j = i-1; j > a; j--) {
                    if(s.charAt(i)==s.charAt(j)){
                        a=j;
                    }else{
                        list.add(s.charAt(j));
                    }
                }
            }else{
                list.add(s.charAt(i));
            }
        }
        return Math.max(result,list.size());
    }

    public static int lengthOfLongestSubstring2(String s) {//s=adbavbf
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public static int lengthOfLongestSubstring3(String s) {//s=adbavbf
        //总体思路：
        /*
        *   1. 利用hashSet存储字符
        *   2. 左指针右指针的配合
        *   3. 滑动窗口的思想
        *
        * */
        Set<Character> ooc = new HashSet<>();
        int result=0;
        int right=0;
        for (int i = 0; i < s.length(); i++) {
            if(i!=0) {
                ooc.remove(s.charAt(i - 1));
            }
            while(right<s.length()&&!ooc.contains(s.charAt(right))){
                ooc.add(s.charAt(right));
                right++;
            }
            //right=5;
            result=Math.max(result,ooc.size());//4
            if(right>=s.length())
                break;
        }
        return result;
    }
}
