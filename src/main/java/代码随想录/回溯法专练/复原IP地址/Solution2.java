package 代码随想录.回溯法专练.复原IP地址;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().restoreIpAddresses("101023"));
    }

    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        backTrack(s, 0, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(String s, int start, int len, List<String> list) {
        if (list.size() > 4) {
            return;
        }
        if (len == s.length()) {
            if (list.size() == 4) {
                StringBuilder ss=new StringBuilder();
                for (int i = 0; i < list.size()-1; i++) {
                    ss.append(list.get(i)).append(".");
                }
                ss.append(list.get(list.size()-1));
                result.add(ss.toString());
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (checkStr(substring)) {
                list.add(substring);
                backTrack(s, i + 1, len + substring.length(), list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean checkStr(String substring) {
        if (substring.length() == 1) {
            return true;
        }
        if (substring.length() > 3 || substring.charAt(0) == '0') {
            return false;
        }
        Integer integer = Integer.valueOf(substring);
        if (integer > 255) {
            return false;
        }
        return true;
    }
}
