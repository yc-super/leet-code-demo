package 代码随想录.贪心算法.根据身高重建队列;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] people=new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(new Solution().reconstructQueue(people));
    }
    //代码随想录，先
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]) {
                    return o2[0]-o1[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });

        LinkedList<int[]> list=new LinkedList<>();
        for(int[]a :people){
            list.add(a[1],a);
        }

        return list.toArray(new int[people.length][]);
    }
}
