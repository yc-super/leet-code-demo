package 灵神.IP地址无效化;

public class Solution {
    public String defangIPaddr(String address) {
        char[] chars = new char[address.length() + 6];
        int index = 0;
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                chars[index++] = '[';
                chars[index++] = '.';
                chars[index++] = ']';
            } else {
                chars[index++] = address.charAt(i);
            }
        }
        return new String(chars);
    }
}
