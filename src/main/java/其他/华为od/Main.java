package 其他.华为od;

import java.util.*;

//区间连接器
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer[]> list=new ArrayList<>();
        int count=0;
        String str = in.nextLine();
        if(str==null||str.equals("")){
            System.out.println(0);
            return;
        }
        String[] str2 = str.split(",");
        for (int i = 0; i < str2.length; i++) {
            if(i%2==0){
                str2[i]=str2[i].substring(1);
                list.add(new Integer[]{Integer.valueOf(str2[i]),0});
            }else{
                str2[i]=str2[i].substring(0,str2[i].length()-1);
                list.get(i/2)[1]=Integer.valueOf(str2[i]);
            }
        }
        count=list.size();

        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0]==o2[0]) {
                    return 0;
                }else if (o1[0]>o2[0]) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        //debug看下list
        List<Integer> ll=new ArrayList<>();
        int temp=list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            Integer num = list.get(i)[0];
            if(temp>=num){
                count--;
            }else{
                ll.add(num-temp);
            }
            temp=Math.max(list.get(i)[1],temp);
        }
        if(ll.size()==0) {
            System.out.println(1);
            return;
        }

        String str3 = in.nextLine();
        if(str3==null||str3.equals("")||str3.equals("[]")){
            System.out.println(ll.size());
            return;
        }

        String[] str4 = str3.split(",");
        str4[0]=str4[0].substring(1);
        str4[str4.length-1]=str4[str4.length-1].substring(0,str4[str4.length-1].length()-1);
        int[] cc=new int[str4.length];//连接器
        for (int i = 0; i < str4.length; i++) {
            cc[i]=Integer.valueOf(str4[i]);
        }

        ll.sort(Integer::compareTo);
        Arrays.sort(cc);
        int index=0;
        //贪心
        /*for (int i = 0; i < ll.size(); i++) {
            while(index<cc.length){
                if(cc[index]>=ll.get(i)){
                    count--;
                    break;
                }
                index++;
            }
        }*/
        for (int i = 0; i < ll.size(); i++) {
            for (int j = 0; j < cc.length; j++) {
                if(cc[j]==ll.get(i)){
                    count--;
                    cc[j]=0;
                    break;
                }else if(cc[j]>ll.get(i)){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
