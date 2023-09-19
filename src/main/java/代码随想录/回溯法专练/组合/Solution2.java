package 代码随想录.回溯法专练.组合;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        list = new ArrayList<>();
        combine(n, k, 1);
        return result;
    }

    private void combine(int n, int k, int start) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            combine(n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private List<List<Integer>> result;
    private List<Integer> list;
}
