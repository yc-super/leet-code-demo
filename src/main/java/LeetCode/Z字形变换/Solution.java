package LeetCode.Z字形变换;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }


    //想了半天，还是不对，我是菜逼。不过这样的题目不想出来巧妙的办法真的很难写对啊。
    //另外：还可以用二维数组模拟
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows >= len || numRows == 1)
            return s;
        int n = (len - numRows) / (2 * numRows - 2);
        int num = (len - numRows) % (2 * numRows - 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(s.charAt(i));
            for (int j = 1; j <= n; j++) {
                if (i != numRows - 1)
                    sb.append(s.charAt(i + (2 * (numRows - i - 1)) + (j - 1) * (numRows - 1)));
                if (i != 0) {
                    sb.append(s.charAt(i + (2 * (numRows - i - 1)) + (j - 1) * (numRows - 1) + 2 * i));
//                    sb.append(s.charAt(i + (j + 1) * (2 * (numRows - i - 1)) + 2 * i));
                }
            }
            if (num == 0)
                continue;
            if (num <= numRows - 1) {
                if (i == numRows - 1)
                    continue;
                if (num >= numRows - i - 1) {
                    sb.append(s.charAt(i + (2 * (numRows - i - 1)) + (n - 1) * (numRows - 1)));
                }
            } else {
                sb.append(s.charAt(i + (2 * (numRows - i - 1)) + (n - 1) * (numRows - 1)));
                if (num >= i + numRows - 1) {
                    if (i != 0) {
                        sb.append(s.charAt(i + (2 * (numRows - i - 1)) + (n - 1) * (numRows - 1) + 2 * i));
                    }
                }
            }
        }
        return sb.toString();
    }

    //评论里的题解，很巧妙，用flag不断更新行数
    public String convert2(String s, int numRows) {
        if (numRows < 2)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1)
                flag = -flag;
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            sb.append(list.get(j));
        }
        return sb.toString();
    }
}
