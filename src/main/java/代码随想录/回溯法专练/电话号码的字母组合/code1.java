package 代码随想录.回溯法专练.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class code1 {
    public static void main(String[] args) {
//        String digits = "23";
        String digits = "";
//        String digits = "27";
        System.out.println(new code1().letterCombinations(digits));

    }
    private List<String> list;
    private String[] array={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        list=new ArrayList<>();
        if(digits==null||digits.equals(""))
            return list;
        backTrack(0,digits,new StringBuilder());
        return list;
    }

    //"23"  abc   def
    //["ad","ae","af","bd","be","bf","cd","ce","cf"]
    private void backTrack(int start, String digits,StringBuilder sb) {
        if(sb.length()==digits.length()){
            list.add(sb.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int index=digits.charAt(i)-'0'-2;
            for (int j = 0; j < array[index].length(); j++) {
                sb.append(array[index].charAt(j));
                backTrack(i+1,digits,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
