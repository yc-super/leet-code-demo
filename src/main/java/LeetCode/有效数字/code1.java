package LeetCode.有效数字;
/*
* 困难题
* */
public class code1 {
    public static void main(String[] args) {
        String s = ".1";
        System.out.println(isNumber(s));
    }
    public static boolean isNumber(String s) {

        Integer index = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'e' || chars[i] == 'E') {
                if (index == -1) index = i;
                else return false;
            }
        }
        if (index == -1){
            return isNumber(chars,0, chars.length-1, false);
        }else {
            return isNumber(chars,0,index-1,false) & isNumber(chars, index+1, chars.length-1, true);
        }

    }

    private static boolean isNumber (char[] chars, Integer beginIndex, Integer lastIndex, Boolean isInteger) {
        if (beginIndex > lastIndex) return false;

        if(chars[beginIndex] == '+' || chars[beginIndex] == '-'){
            beginIndex++;
        }
        Boolean hasDot = false, hasNumber = false;
        for (int i = beginIndex; i <= lastIndex ; i++) {
            if (chars[i] == '.') {
                // if (isInteger) return false;
                // if (firstTime) firstTime = false;
                // else return false;
                if (hasDot | isInteger) return false;
                hasDot = true;
            }else if (chars[i] >= '0' && chars[i] <= '9') {
                hasNumber = true;
            } else {
                return false;
            }
        }
        return hasNumber;

    }
}
