package LeetCode.课程表4;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = {{1, 0}, {1, 2}};
        System.out.println(new Solution().checkIfPrerequisite2(numCourses, prerequisites, queries));
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<Integer>();
        }
        int[] indgree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            ++indgree[p[1]];
            g[p[0]].add(p[1]);
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int ne : g[cur]) {
                isPre[cur][ne] = true;
                for (int i = 0; i < numCourses; ++i) {
                    isPre[i][ne] = isPre[i][ne] | isPre[i][cur];
                }
                --indgree[ne];
                if (indgree[ne] == 0) {
                    queue.offer(ne);
                }
            }
        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }


    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] rudu = new int[numCourses];
        List<Integer>[] yilai = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            yilai[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            rudu[prerequisites[i][1]]++;
            yilai[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (rudu[i] == 0) {
                queue.offer(i);
            }
        }
        boolean[][] isYilai = new boolean[numCourses][numCourses];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer ll : yilai[cur]) {
                isYilai[cur][ll] = true;
                for (int i = 0; i < numCourses; i++) {
                    isYilai[i][ll] = isYilai[i][ll] || isYilai[i][cur];
                }
                rudu[ll]--;
                if (rudu[ll] == 0) {
                    queue.offer(ll);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            result.add(isYilai[queries[i][0]][queries[i][1]]);
        }
        return result;
    }
}

