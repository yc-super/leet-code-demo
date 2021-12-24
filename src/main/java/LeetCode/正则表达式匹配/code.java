package LeetCode.正则表达式匹配;

public class code {
    public static void main(String[] args) {
//        String s = "aa",p = "a";//f
//        String s = "aa",p = "a*";//t
//        String s = "ab",p = ".*";//t
//        String s = "aab",p = "c*a*b";//t
//        String s = "mississippi",p = "mis*is*p*.";//f
//        String s = "misssisi",p = "mis*is.";//f
        String s = "mi",p = ".*i";//f
        System.out.println(new code().isMatch2(s,p));
    }
    /*public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        char[] s2 = new char[ss.length];
        int sIndex=0;
        for (int i = 0; i < p.length(); i++) {
            if(i+1)
        }
    }*/
    public boolean isMatch2(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        char[] s2 = new char[ss.length];
        int pIndex=0;
        for (int i = 0; i < s.length(); i++) {
            if(pIndex==p.length())
                return false;
            if(ss[i]==pp[pIndex]){
                pIndex++;
                s2[i]=ss[i];
                continue;
            }else{
                //abc   c*d*bc
                if(pp[pIndex]>='a'&&pp[pIndex]<='z') {
                    if(pIndex+1<p.length()&&pp[pIndex+1]=='*'){
                       i--;
                       pIndex+=2;
                    }else {
                        return false;
                    }
                }else if(pp[pIndex]=='*'){
                    if(ss[i]!=s2[i-1]){
                        if(pp[pIndex-1]=='.'){
                            s2[i]=ss[i];
                            continue;
                        }else {
                            pIndex++;
                            continue;
                        }
                    }
                    while(ss[i]==s2[i-1]){
                        s2[i]=ss[i];
                        i++;
                        if(i==s.length()){
                            pIndex=p.length();
                            break;
                        }
                    }
                    i--;
                    pIndex++;
                    continue;
                }else if(pp[pIndex]=='.'){
                    s2[i]=ss[i];
                    if(pIndex+1<p.length()) {
                        if (pp[pIndex + 1] != '*') {
                            pIndex++;
                        }
                    }else if(pIndex==p.length()-1){
                        pIndex++;
                        continue;
                    }
                }
            }
        }
        //检查剩下的p是否合规
        if(pIndex==p.length()){
            return true;
        }else{
            for (int j = pIndex; j < p.length(); j++) {
                if(pp[j]!='.'&&pp[j]!='*')
                    return false;
            }
        }
        return true;
    }
}
