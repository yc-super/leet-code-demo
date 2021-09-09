package LeetCode.回溯法专练.重新安排行程;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        List<List<String>> tickets=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        list1.add("JFK");
        list1.add("SFO");
        tickets.add(list1);
        List<String> list2=new ArrayList<>();
        list2.add("JFK");
        list2.add("ATL");
        tickets.add(list2);
        List<String> list3=new ArrayList<>();
        list3.add("SFO");
        list3.add("ATL");
        tickets.add(list3);
        List<String> list4=new ArrayList<>();
        list4.add("ATL");
        list4.add("JFK");
        tickets.add(list4);
        List<String> list5=new ArrayList<>();
        list5.add("ATL");
        list5.add("SFO");
        tickets.add(list5);
        List<String> result = new MyCode().findItinerary(tickets);
        System.out.println(result);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        vis=new boolean[tickets.size()];
        res=new ArrayList<>();
        sortTickets(tickets);
        findOne(tickets);

        backTrack(tickets);
        return res;
    }
    private void sortTickets(List<List<String>> tickets){
        for (int i = 0; i < tickets.size()-1; i++) {
            for (int j = i+1; j < tickets.size(); j++) {
                if(tickets.get(i).get(0)==tickets.get(j).get(0)){
                    if(sortString(tickets.get(i).get(1),tickets.get(j).get(1))){
                        String s=tickets.get(i).get(1);
                        tickets.get(i).set(1,tickets.get(j).get(1));
                        tickets.get(j).set(1,s);
                    }
                }
            }

        }
    }

    private boolean sortString(String s, String s1) {
        for (int i = 0; i < 3; i++) {
            if(s.charAt(i)>s1.charAt(i))
                return true;
            if(s.charAt(i)<s1.charAt(i))
                return false;
        }
        return false;
    }

    private void findOne(List<List<String>> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            if(tickets.get(i).get(0).equals("JFK")){
                res.add("JFK");
                res.add(tickets.get(i).get(1));
                vis[i]=true;
                return ;
            }
        }
    }

    List<String> res;
    boolean[] vis;
    private void backTrack(List<List<String>> tickets) {
        /*if(res.size()==tickets.size()+1){
            return;
        }*/
        for (int i = 0; i < tickets.size(); i++) {
            if(vis[i]||!tickets.get(i).get(0).equals(res.get(res.size()-1)))
                continue;
            res.add(tickets.get(i).get(1));
            vis[i]=true;
            backTrack(tickets);
            if(res.size()==tickets.size()+1){
                return;
            }
            vis[i]=false;
            res.remove(res.size()-1);
        }
    }
}
