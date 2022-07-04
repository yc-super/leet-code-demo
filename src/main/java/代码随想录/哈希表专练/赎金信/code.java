package 代码随想录.哈希表专练.赎金信;

import java.util.HashMap;
import java.util.Map;

public class code {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "bab";
        System.out.println(new code().canConstruct2(ransomNote,magazine));
    }
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] array=new int[26];
        for(char c:magazine.toCharArray()){
            array[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            array[c-'a']--;
        }
        for(int i:array){
            if(i<0)
                return false;
        }
        return true;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:magazine.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for(char c:ransomNote.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)<0){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
