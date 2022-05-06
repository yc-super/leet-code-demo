package 哈希表专练.有效的字母异位词;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class code {
    public static void main(String[] args) {
        String s="nl";
        String t="cx";
        System.out.println(new code().isAnagram2(s,t));
    }
    //map
    public boolean isAnagram(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        if(len1!=len2)
            return false;
        Map<Character,Integer> map=new HashMap<>();
        char c;
        for (int i = 0; i < len1; i++) {
            c=s.charAt(i);
            if(map.get(c)!=null){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        Integer value=null;
        for (int i = 0; i < len1; i++) {
            c=t.charAt(i);
            value=map.get(c);
            if(value!=null){
                map.put(c,value-1);
            }else{
                return false;
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for(Map.Entry<Character,Integer> entry:entries){
            if(entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }

    //哈希表原理
    public boolean isAnagram2(String s, String t) {
        int[] array=new int[26];
        for (char chr:s.toCharArray()) {
            array[chr-'a']+=1;
        }
        for (char chr:t.toCharArray()) {
            array[chr-'a']-=1;
        }
        for (int i = 0; i < 26; i++) {
            if(array[i]!=0){
                return false;
            }
        }
        return true;
    }
}
