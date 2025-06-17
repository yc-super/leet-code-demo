package 宫水三叶.DFS.为运算表达式设计优先级;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        List<Integer> integers = new Solution().diffWaysToCompute("2*3-4*5");
        System.out.println();
    }

    // 三叶姐的题解。和 不同的二叉搜索树 一样思路

    List<Integer> ans1;

    public List<Integer> diffWaysToCompute(String expression) {
        return myDFS2(expression, 0, expression.length() - 1);
    }

    private List<Integer> myDFS2(String expression, int l, int r) {
        String str = expression.substring(l, r + 1);
        if (checkStr(str)) {
            return new ArrayList<Integer>(){{add(Integer.parseInt(str));}};
        }

        List<Integer> ll = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            List<Integer> l1 = myDFS2(expression, l, i - 1);
            List<Integer> l2 = myDFS2(expression, i + 1, r);
            for (int j = 0; j < l1.size(); j++) {
                for (int k = 0; k < l2.size(); k++) {
                    Integer i1 = l1.get(j);
                    Integer i2 = l2.get(k);
                    if (c == '-') {
                        ll.add(i1 - i2);
                    } else if (c == '+') {
                        ll.add(i1 + i2);
                    } else {
                        ll.add(i1 * i2);
                    }
                }
            }
        }
        return ll;
    }

    private boolean checkStr(String str) {
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }


    /*
     * 我的题解，dfs，失败了，有一种情况无法处理
     * */
    List<Integer> ans;

    public List<Integer> diffWaysToCompute2(String expression) {
        ans = new ArrayList<>();
        Map<Integer, Integer> map = getCountFromStr(expression);
        myDFS(expression);
        return ans;
    }

    private void myDFS(String expression) {


        Map<Integer, Integer> map = getCountFromStr(expression);
        if (map.size() == 0) {
            ans.add(Integer.valueOf(expression));
            return;
        }


        for (int i = 0; i < map.size(); i++) {
            Integer j = map.get(i);
            char c = expression.charAt(j);

            Integer index1 = map.getOrDefault(i - 1, -1) + 1;
            Integer index2 = map.getOrDefault(i + 1, expression.length());
            int n1 = Integer.parseInt(expression.substring(index1, j));
            int n2 = Integer.parseInt(expression.substring(j + 1, index2));
            int value;
            if (c == '-') {
                value = n1 - n2;
            } else if (c == '+') {
                value = n1 + n2;
            } else {
                value = n1 * n2;
            }

            // 处理expression
            String str1 = "", str2 = "";
            String preExe = expression;
            if (index1 > 0) {
                str1 = expression.substring(0, index1);
            }
            if (index2 < expression.length()) {
                str2 = expression.substring(index2);
            }
            expression = str1 + value + str2;

            myDFS(expression);

            expression = preExe;

        }
    }


    // 2*-1,-1*-2,-1*2
    private Map<Integer, Integer> getCountFromStr(String expression) {
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                map.put(num++, i++);
            }
        }
        return map;
    }
}
