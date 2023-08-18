package 代码随想录.字符串.替换空格;

public class code {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if(' '==chars[i]){
                count++;
            }
        }
        if(count==0)
            return s;
        char[] array=new char[s.length()+count*2];
        int index=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                array[index++]='%';
                array[index++]='2';
                array[index++]='0';
            }else {
                array[index++] = chars[i];
            }
        }
        return String.valueOf(array);
    }
}
