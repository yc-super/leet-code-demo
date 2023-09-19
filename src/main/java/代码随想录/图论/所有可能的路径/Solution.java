package 代码随想录.图论.所有可能的路径;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(new Solution().allPathsSourceTarget(graph));
    }

    List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        ll.add(0);
        backTrack(graph, 0, ll);
        return result;

    }

    private void backTrack(int[][] graph, int start, List<Integer> list) {
        if (list.get(list.size() - 1) == graph.length - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (graph[start] == null || graph[start].length == 0) {
            return;
        }
        for (int i = 0; i < graph[start].length; i++) {
            list.add(graph[start][i]);
            backTrack(graph, graph[start][i], list);
            list.remove(list.size() - 1);
        }
    }
}
