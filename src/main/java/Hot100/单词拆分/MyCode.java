package Hot100.单词拆分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//回溯法，虽然优化了2次，但还是超时了
public class MyCode {
    public static void main(String[] args) {
//        String s = "catsandog";
//        String s = "catsandcat";
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s = "aaab";
        List<String>  wordDict = new ArrayList<>();
//        wordDict.add("cat");
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("og");

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
            System.out.println(new MyCode().wordBreak(s,wordDict));
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Comparator com= Comparator.comparingInt(o -> o.toString().length());
        String[] wordArray = wordDict.toArray(new String[0]);
        Arrays.sort(wordArray,com);
        List<String> list=new ArrayList<>();
        list.add(wordArray[0]);
        for (int i = 1; i < wordArray.length; i++) {
            if(!checkStr(list,wordArray[i]))
                list.add(wordArray[i]);
        }
        return backTrack(s.toCharArray(),list,0);
    }

    private boolean checkStr(List<String> list, String str) {
        int i;
        int len;
        for(String s:list){
            i=0;
            len=s.length();
            if(str.length()%len!=0)
                continue;
            //ss,sssa
            while(i<str.length()&&str.substring(i,i+len).equals(s)){
                i+=len;
            }
            if(i>=str.length())
                return true;
        }
        return false;
    }

    //超出时间限制
    /*
    * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
*
* "bccdbacdbdacddabbaaaadababadad"
["cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"]
*
* "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"]
* 化简后应该只有aa,aaa,ba
    * */
    private boolean backTrack(char[] s, List<String> wordDict, int start) {
        for (int i = 0; i < wordDict.size(); i++) {
            if(s[start]==wordDict.get(i).charAt(0)){

                //[start,s.length]的长度小于wordDirect.get(i)的长度，那么直接return false
                if(s.length-start+1<wordDict.get(i).length())
                    return false;

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
                        }
                    }
                }
            }
        }
        return false;
    }
}
