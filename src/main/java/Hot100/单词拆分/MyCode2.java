package Hot100.单词拆分;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyCode2 {
    public static void main(String[] args) {
        String s = "catsandog";
//        String s = "catsandcat";
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s = "aaab";
        List<String>  wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("og");

//        wordDict.add("a");
//        wordDict.add("aa");
//        wordDict.add("aaa");
//        wordDict.add("aaaa");
//        wordDict.add("aaaaa");
//        wordDict.add("aaaaaa");
//        wordDict.add("aaaaaaa");
//        wordDict.add("aaaaaaaa");
//        wordDict.add("aaaaaaaaa");
//        wordDict.add("aaaaaaaaaarrrrr");
//        wordDict.add("aaaaaaaaaa");

//        wordDict.add("aa");
//        wordDict.add("aaa");
//        wordDict.add("aaaaa");
//        wordDict.add("aaaa");
//        wordDict.add("aaaaa");
//        wordDict.add("aaaaaa");
//        wordDict.add("aaaaaaa");
//        wordDict.add("aaaaaaaa");
//        wordDict.add("aaaaaaaaa");
//        wordDict.add("aaaaaaaaaarrrrr");
//        wordDict.add("aaaaaaaaaa");


        for (int i = 0; i < 1; i++) {
            System.out.println(new MyCode2().wordBreak(s,wordDict));
        }
    }

    /*
    * 动态规划
    * 1. 确定dp数组及下标的含义
     *   dp[i]表示s的位置i能否由wordDirect中的单词组成
    * 2. 确定递推公式
    *      dp[i]=dp[j]&&check(s[j,i-1])
    * 3.初始化
    *   dp[0]=true
    *   dp[1]=dp[0]&&check(1)
    *   dp[2]=(dp[1]&&check(2))||(dp[0]&&check(1,2))
    *
    * 时间复杂度：//(n*(n+1))/2，O(n2)
    * */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]&&set.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //剪枝
    //动态规划剪枝，如果内循环中j到i的长度大于wordDirect中最长的，直接break
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        int maxLen=0;
        boolean[] dp=new boolean[s.length()+1];
        for(String str:wordDict){
            set.add(str);
            maxLen=Math.max(maxLen,str.length());
        }
        dp[0]=true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = i-1; j >=0&&(j>=i-maxLen); j--) {
                if(dp[j]&&set.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
