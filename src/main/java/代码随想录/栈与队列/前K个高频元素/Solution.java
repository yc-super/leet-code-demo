package 代码随想录.栈与队列.前K个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* 思路1：遍历nums，同时哈希表把每个元素出现次数存下来，然后快速排序（可以定义一个数组，然后快速排序）
* 但这样肯定不是最优解（前k个高频元素，这就意味着不必把所有的顺序都算出来，快排是把所有元素的优先级都算出来了），甚至不能通过这个题
* 思路还是应该往栈与队列靠
*
* 思路2：遍历nums，同时哈希表把每个元素出现次数存下来，定义两个栈，往第一个栈push值，当push的值比栈顶元素大时，先把栈顶元素不断往第二个栈移，
* */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3,3};
//        int[] nums = {5,4,3,2,5,4,3,5,4};
        int[] nums = {1,2,2,3,3,3,4,4,4,4,5};
//        int[] nums = {1,2,3,4,1};
        int k = 2;
        int[] ints = new Solution().topKFrequent2(nums, k);
        for(int i:ints){
            System.out.println(i);
        }
    }

    /*
    * 代码随想录，前面用map存储数据和我想的一样，后面多了个PriorityQueue数据结构我之前没了解过
    * 小顶堆
    * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
//        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(pair -> pair[1]));
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(priorityQueue.size()<k){
                priorityQueue.add(new int[]{entry.getKey(),entry.getValue()});
            }else{
                if(entry.getValue()>priorityQueue.peek()[1]){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        int[] result=new int[k];
        for (int i = k-1; i >=0 ; i--) {
            result[i]=priorityQueue.poll()[0];
        }
        return result;
    }

    //大顶堆
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] result=new int[k];
        for (int i = 0; i <=k-1 ; i++) {
            result[i]=priorityQueue.poll()[0];
        }
        return result;
    }
}
