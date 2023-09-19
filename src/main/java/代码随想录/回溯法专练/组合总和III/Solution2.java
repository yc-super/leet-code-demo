package 代码随想录.回溯法专练.组合总和III;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k, n, 1);
        return result;
    }

    private void backTrack(int k, int n, int start) {
        if (sum > n)
            return;
        if (list.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9-(k-list.size())+1; i++) {
            list.add(i);
            sum += i;
            backTrack(k, n, i + 1);
            list.remove(list.size() - 1);
            sum -= i;
        }
    }
}
