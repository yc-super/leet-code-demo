package Hot100.单词拆分;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
//        String s = "catsandog";
        String s = "catsandcat";
        List<String>  wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("og");
        System.out.println(new MyCode().wordBreak(s,wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return backTrack(s.toCharArray(),wordDict,0);
    }

    //超出时间限制
    /*
    * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    * */
    private boolean backTrack(char[] s, List<String> wordDict, int start) {
        for (int i = 0; i < wordDict.size(); i++) {
            if(s[start]==wordDict.get(i).charAt(0)){
                int k=start;
                int l=0;
                while(l<wordDict.get(i).length()&&k<s.length&&s[k]==wordDict.get(i).charAt(l)){
                    k++;
                    l++;
                }
                if(l==wordDict.get(i).length()){
                    if(k==s.length) {
                        return true;
                    }else{
                        if(backTrack(s,wordDict,k)){
                            return true;
                        }else{
                            continue;
                        }
                    }
                }
            }
        }
        return false;
    }
}
