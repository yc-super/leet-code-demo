package 宫水三叶.DFS.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        List<String> strings = new Solution().letterCombinations("234");
        System.out.println();
    }

    /*
    * 我的题解，经典的dfs回溯法
    * */
    Map<Character,String> map=new HashMap<>();
    List<String> ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null|| digits.isEmpty()){
            return new ArrayList<>();
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        char[] charArray = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(charArray,0,sb);
        return ans;
    }
    private void dfs(char[] charArray, int start, StringBuilder sb){
        if(sb.length()==charArray.length){
            ans.add(sb.toString());
            return;
        }

        String s = map.get(charArray[start]);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(charArray,start+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
