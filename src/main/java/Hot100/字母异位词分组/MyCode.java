package Hot100.字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicStampedReference;

//超时了
public class  MyCode {
    /*
    * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
* 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
*
输入: strs = [""]
输出: [[""]]
*
* 思路1：
* map数组，存储字符个数，遍历strs，是否与map数组中的某个map匹配
    * */
    public static void main(String[] args) {
//       String[] strs = {"","","","eat","eatv", "tea", "tan", "ate", "nat", "bat"};
       String[] strs = {"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};
        List<List<String>> lists = new MyCode().groupAnagrams(strs);
        System.out.println(lists);
    }
    List<Map<Character,Integer>> mapArray=new ArrayList<>();
    List<List<String>> lists=new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        int emptyNum=0;
        for (int i = 0; i < strs.length; i++) {
            if(mapArray.size()==0){
                if(strs[i].length()==0){
                    emptyNum++;
                    continue;
                }
                addToMap(strs[i]);
            }else{
                if(strs[i].length()==0){
                    emptyNum++;
                    continue;
                }
                addToList(strs[i]);
            }
        }
        if(emptyNum>0){
            List<String> list=new ArrayList<>();
            for (int i = 0; i < emptyNum; i++) {
                list.add("");
            }
            lists.add(list);
        }
        return lists;
    }

    private void addToMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        mapArray.add(map);
        List<String> list=new ArrayList<>();
        list.add(s);
        lists.add(list);
    }

    private boolean addToList(String s) {
        Map<Character, Integer> map;
        for (int i = 0; i < mapArray.size(); i++) {
            if(lists.get(i).get(0).length()!=s.length()){
                continue;
            }
            map = new HashMap<>(mapArray.get(i));
            boolean flag=true;
            for (int j = 0; j < s.length(); j++) {
                if(map.containsKey(s.charAt(j))){
                    if(map.get(s.charAt(j))-1<0) {
                        flag=false;
                        break;
                    }
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                }
            }
            //检查map所有value是否都为0
            for(Integer integer:map.values()){
                if(integer!=0){
                    flag=false;
                    break;
                }
            }
            if(flag) {
                lists.get(i).add(s);
                return true;
            }
        }
        addToMap(s);
        return false;
    }
}
