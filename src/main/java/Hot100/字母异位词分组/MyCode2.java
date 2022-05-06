package Hot100.字母异位词分组;

import java.util.*;

//排序
// 时间复杂度O(nklogk),n是strs长度，k是最长字符串的长度。
// 空间复杂度O(nk),n是strs长度，k是最长字符串的长度。
public class MyCode2 {
    public static void main(String[] args) {
        String[] strs = {"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};
        List<List<String>> lists = new MyCode2().groupAnagrams(strs);
        System.out.println(lists);
    }
    private List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
