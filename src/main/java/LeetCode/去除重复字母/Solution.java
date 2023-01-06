package LeetCode.去除重复字母;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "deadfebcdef";
        System.out.println(new Solution().removeDuplicateLetters2(s));
    }

    public String removeDuplicateLetters(String s) {
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();

        int[] temp = new int[26];
        for (int i = 0; i < chars.length; i++) {
            temp[chars[i] - 'a'] = i;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);

                boolean flag = true;
                for (int j = 0; j < list.size(); j++) {
                    if (chars[i] < list.get(j)) {
                        flag = true;
                        for (int k = j; k < list.size(); k++) {
                            if (temp[list.get(k)-'a'] < i) {
                                flag = false;
                                j = k;
                                break;
                            }
                        }
                        if (flag) {
//                            list.add(j,chars[i]);
                            int k = j;
                            int size = list.size();
                            while (k < size) {
                                set.remove(list.get(k));
                                list.remove(k);
                                size--;
                            }
                            break;
                        }
                    }
                }
                list.add(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    public String removeDuplicateLetters2(String s) {
        StringBuilder sb=new StringBuilder();
        char[] chars = s.toCharArray();
        boolean[] visit=new boolean[26];
        int[] nums=new int[26];

        for (int i = 0; i < chars.length; i++) {
            nums[chars[i]-'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            nums[chars[i]-'a']--;

            if(!visit[chars[i]-'a']) {
                while (sb.length()>0 && sb.charAt(sb.length() - 1) > chars[i]) {
                    if(nums[sb.charAt(sb.length() - 1)-'a']<=0){
                        break;
                    }
                    visit[sb.charAt(sb.length() - 1)-'a']=false;
                    sb.deleteCharAt(sb.length()-1);
                }
                visit[chars[i]-'a']=true;
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
