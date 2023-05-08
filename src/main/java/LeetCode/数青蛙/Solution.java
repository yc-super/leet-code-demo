package LeetCode.数青蛙;

public class Solution {
    //我自己想出来可以用栈类似的数据结构，但没想到只是计数就行了，利用其中的规律
    // croackroak
    //        //croccroakroakak
    //        //ack
    //        //ccrcrocroacroakkakoakroak
    //        //croka
    //        //ok
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0)
            return -1;
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int res = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char charAt = croakOfFrogs.charAt(i);
            if (charAt == 'c')
                c++;
            else if (charAt == 'r')
                r++;
            else if (charAt == 'o')
                o++;
            else if (charAt == 'a')
                a++;
            else
                k++;

            if (c < r || r < o || o < a || a < k)
                return -1;
            res = Math.max(res, c - k);
        }
        return c == r && r == o && o == a && a == k ? res : -1;
    }
}
