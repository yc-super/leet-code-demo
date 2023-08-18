package 代码随想录.哈希表专练.赎金信;

import java.util.HashMap;
import java.util.Map;

public class code1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (char c : magazine.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (array[c - 'a'] <= 0)
                return false;
            array[c - 'a']--;
        }
        return true;
    }
}
