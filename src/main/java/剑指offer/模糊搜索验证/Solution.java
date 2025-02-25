package 剑指offer.模糊搜索验证;

public class Solution {
    public static void main(String[] args) {
        String s = "bcbabcaacacbcabac";
        String p = "a*c*a*b*.*aa*c*a*a*";
        System.out.println(new Solution().articleMatch(s, p));
    }

    public boolean articleMatch(String s, String p) {
        if(p==null|| p.isEmpty()){
            return s == null || s.isEmpty();
        }
        if(s==null||s.isEmpty())
            return myCheck(p,0);
        char c = p.charAt(p.length() - 1);
        if (c != '.' && c != '*' && c != s.charAt(s.length()-1))
            return false;
        return backTrack(s, p, 0, 0);
    }

    // 自己写的，回溯法，注意 匹配到了/./*，既可以认为匹配，也可以认为不匹配而进行下一个继续尝试匹配
    // 优化点：回溯中很多重复计算，可以利用二维数组保存起来
    private boolean myCheck(String p, int j) {
        if (j == p.length() - 1 && p.charAt(j) == '*')
            return true;
        if ((p.length() - j) % 2 != 0)
            return false;
        // 检查是否后面都是x*的格式
        for (int k = j; k < p.length(); k += 2) {
            if (p.charAt(k + 1) != '*')
                return false;
        }
        return true;
    }

    public boolean backTrack(String s, String p, int i, int j) {
        if (i == s.length()) {
            if (j == p.length())
                return true;
            return myCheck(p,j);
        }
        if (j == p.length())
            return false;

        char c = s.charAt(i);
        char pc = p.charAt(j);
        if (pc == c) {
            boolean aa = backTrack(s, p, i + 1, j + 1);
            if (aa)
                return true;
            if (j + 1 != p.length() && p.charAt(j + 1) == '*') {
                return backTrack(s, p, i, j + 1);
            }
            return false;
        } else if (pc == '.') {
            boolean aa = backTrack(s, p, i + 1, j + 1);
            if (aa)
                return true;
            if (j + 1 != p.length() && p.charAt(j + 1) == '*') {
                return backTrack(s, p, i, j + 1);
            }
            return false;
        } else if (pc == '*') {// *
            char pc1 = p.charAt(j - 1);
            if (pc1 == c || pc1 == '.') {
                return backTrack(s, p, i + 1, j) || backTrack(s, p, i, j + 1) || backTrack(s, p, i + 1, j + 1);
            } else {
                return backTrack(s, p, i, j + 1);
            }
        }
        // 不等
        if (j < p.length() - 1 && p.charAt(j + 1) == '*')
            return backTrack(s, p, i, j + 1);
        return false;
    }
}
