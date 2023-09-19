package 代码随想录.回溯法专练.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

// 通过debug可以看出，这个代码写得非常冗余
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().letterCombinations("258"));
    }
    public List<String> letterCombinations(String digits) {
        list=new ArrayList<>();
        if(digits==null||digits.equals(""))
            return list;
        backTrack(0,digits,new StringBuilder());
        return list;
    }
    private List<String> list;
    private String[] array={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
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
