package 代码随想录.回溯法专练.分割回文串;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
//        System.out.println(new Solution2().partition("abaaba"));
        new Solution2().isHuiWen2("abaaba");
        System.out.println();
    }

    //abaaba
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(String s, int start, List<String> list) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = start; j < s.length(); j++) {
            String substring = s.substring(start, j + 1);
            if (isHuiWen(substring)) {
                list.add(substring);
                backTrack(s, j + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isHuiWen(String str) {
        int len = str.length();
        int left = 0, right = len - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


    private boolean[][] huiwen;

    private void isHuiWen2(String str) {
        int len = str.length();
        huiwen = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            huiwen[i][i] = true;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i > 1) {
                        if (huiwen[i + 1][j - 1]) {
                            huiwen[i][j] = true;
                        }
                    } else {
                        huiwen[i][j] = true;
                    }
                }
            }

        }
        System.out.println();
    }

}
