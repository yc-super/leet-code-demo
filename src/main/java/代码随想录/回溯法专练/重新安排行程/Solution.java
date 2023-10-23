package 代码随想录.回溯法专练.重新安排行程;

import java.util.*;

public class Solution {
//    public static void main(String[] args) {
//        List<String> l1 = new ArrayList<>();
//        l1.add("JFK");
//        l1.add("SFO");
//
//        List<String> l2 = new ArrayList<>();
//        l2.add("JFK");
//        l2.add("ATL");
//        List<String> l3 = new ArrayList<>();
//        l3.add("SFO");
//        l3.add("ATL");
//        List<String> l4 = new ArrayList<>();
//        l4.add("ATL");
//        l4.add("JFK");
//        List<String> l5 = new ArrayList<>();
//        l5.add("ATL");
//        l5.add("SFO");
//
//        List<List<String>> ll = new ArrayList<>();
////        ll.add(l1);
////        ll.add(l2);
////        ll.add(l3);
////        ll.add(l5);
////        ll.add(l4);
//
//
////        String[][] aa = new String[][]{{"EZE", "TIA"}, {"EZE", "HBA"}, {"AXA", "TIA"}, {"JFK", "AXA"}, {"ANU", "JFK"},
////                {"ADL", "ANU"}, {"TIA", "AUA"}, {"ANU", "AUA"}, {"ADL", "EZE"}, {"ADL", "EZE"}, {"EZE", "ADL"}, {"AXA", "EZE"},
////                {"AUA", "AXA"}, {"JFK", "AXA"}, {"AXA", "AUA"}, {"AUA", "ADL"}, {"ANU", "EZE"}, {"TIA", "ADL"}, {"EZE", "ANU"}, {"AUA", "ANU"}};
//        String[][] aa = {{"EZE", "TIA"}, {"EZE", "AXA"}, {"AUA", "EZE"}, {"EZE", "JFK"}, {"JFK", "ANU"}, {"JFK", "ANU"}, {"AXA", "TIA"}, {"JFK", "AUA"}, {"TIA", "JFK"}, {"ANU", "EZE"}, {"ANU", "EZE"}, {"TIA", "AUA"}};
//        for (int i = 0; i < aa.length; i++) {
//            List<String> l = new ArrayList<>();
//            l.add(aa[i][0]);
//            l.add(aa[i][1]);
//            ll.add(l);
//        }
//
//        System.out.println(new Solution().findItinerary(ll));
//    }
    /*
    *
     {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},
     {"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},
     {"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}}
    * */

    List<String> result;
    boolean[] vis;
    Map<String, List<Integer>> map;

    public static void main(String[] args) {
        String[][] aa = {{"EZE", "TIA"}, {"EZE", "AXA"}, {"AUA", "EZE"}, {"EZE", "JFK"}};
        List<List<String>> tickets = new ArrayList<>();
        for (int i = 0; i < aa.length; i++) {
            List<String> l = new ArrayList<>();
            l.add(aa[i][0]);
            l.add(aa[i][1]);
            tickets.add(l);
        }
        //根据tickets.get(i).get(1)对tickets排序
        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
    }

    public List<String> findItinerary(List<List<String>> tickets) {
//        Collections的这个sort方法我没用过，用这个方法可以不用新建下面的ticketArray了，可以提高效率
        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        result = new ArrayList<>();
        String[][] ticketArray = new String[tickets.size()][2];
        for (int i = 0; i < tickets.size(); i++) {
            ticketArray[i][0] = tickets.get(i).get(0);
            ticketArray[i][1] = tickets.get(i).get(1);
        }
        Arrays.sort(ticketArray, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
//                for (int i = 0; i < 3; i++) {
//                    if (o1[0].charAt(i) > o2[0].charAt(i)) {
//                        return 1;
//                    } else {
//                        return -1;
//                    }
//                }
                for (int i = 0; i < 3; i++) {
                    if (o1[1].charAt(i) > o2[1].charAt(i)) {
                        return 1;
                    } else if (o1[1].charAt(i) < o2[1].charAt(i)) {
                        return -1;
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        });
        map = new HashMap<>();
        int firstIndex = -1;
        for (int i = 0; i < ticketArray.length; i++) {
            if (firstIndex == -1) {
                if (ticketArray[i][0].equals("JFK")) {
                    firstIndex = i;
                }
            }
            if (!map.containsKey(ticketArray[i][0])) {
                List<Integer> ll = new ArrayList<>();
                ll.add(i);
                map.put(ticketArray[i][0], ll);
            } else {
                List<Integer> ll = map.get(ticketArray[i][0]);
                ll.add(i);
            }
        }
        vis = new boolean[ticketArray.length];
        result.add("JFK");
        backTrack(ticketArray, "JFK");
        return result;
    }

    private List<String> backTrack(String[][] ticketArray, String str) {
        if (result.size() == ticketArray.length + 1) {
            return result;
        }
        List<Integer> list = map.get(str);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Integer index = list.get(i);
                if (vis[index])
                    continue;
                result.add(ticketArray[index][1]);
                vis[index] = true;
                List<String> r = backTrack(ticketArray, ticketArray[index][1]);
                if (r != null)
                    return result;
                result.remove(result.size() - 1);
                vis[index] = false;
            }
        }
        return null;
    }


    /*
    代码随想录，比我的优化2点：
    1. 使用Collections.sort方法，可以不用新建ticketArray了，节省空间
    2. 回溯返回结果使用boolean，更优雅
    */
    private LinkedList<String> res;
    private LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary2(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backTracking((ArrayList) tickets, used);
        return res;
    }

    public boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;

                if (backTracking(tickets, used)) {
                    return true;
                }

                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}
