package 代码随想录.回溯法专练.电话号码的字母组合;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().letterCombinations("258"));
    }

    private List<String> result;
    StringBuilder sb;
    String[] digArray;

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        sb = new StringBuilder();
        digArray = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTrack(chars, 0);

        return result;
    }

    private void backTrack(char[] chars, int index) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }
        String str = digArray[chars[index] - '2'];
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            backTrack(chars, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
