package 宫水三叶.DFS.复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 回溯法，切割问题
    public static void main(String[] args) {
        List<String> strings = new Solution().restoreIpAddresses("25525511135");
        System.out.println();
    }

    List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        List<String> list = new ArrayList<>(s.length() + 3);
        backTrack(s, 0, 0, list);
        return ans;
    }

    private void backTrack(String s, int start, int now, List<String> list) {
        if (list.size() == 4) {
            if (now != s.length()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            return;
        }
        if (now == s.length()) {
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (myCheck(str)) {
                list.add(str);
                backTrack(s, i + 1, i + 1, list);
                list.remove(list.size() - 1);
            } else {
                break;// 剪枝
            }
        }
    }

    private boolean myCheck(String str) {
        if (str.length() == 1)
            return true;
        if (str.length() > 3 || str.charAt(0) == '0')
            return false;
        if (Integer.valueOf(str) > 255)
            return false;
        return true;
    }
}
