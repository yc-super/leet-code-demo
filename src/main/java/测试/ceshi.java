package 测试;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ceshi {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Integer a=127,b=127;
//        System.out.println(a==b);
//        Integer a=128,b=128;
//        System.out.println(a==b);
        String url="%7B%22method%22%3A1%2C%22params%22%3A%7B%22userId%22%3A%2210.214.92.209%22%2C%22fileId%22%3A%22604789777%22%2C%22filePath%22%3A%22%2FFineReport%2010.0%E8%AE%BE%E8%AE%A1%E5%99%A8%E6%96%B0%E5%8A%9F%E8%83%BD%E6%91%B8%E5%BA%95%EF%BC%88%E5%9F%BA%E4%BA%8E8.0%E7%89%88%E6%9C%AC%EF%BC%89docx.docx%22%2C%22userRight%22%3A0%2C%22mobileFlag%22%3Afalse%2C%22saveFlag%22%3Atrue%2C%22fallbackUrl%22%3A%22http%3A%2F%2F10.215.142.54%3A9090%2F%22%2C%22extraData%22%3A%7B%22token%22%3A%22bbb%22%7D%7D%2C%22indexFlag%22%3Atrue%7D";

        String deurl = URLDecoder.decode(url,"UTF-8");
        System.out.println(deurl);

        String url2="%7B%22method%22%3A10003%2C%22params%22%3A%7B%22dirPath%22%3Anull%7D%7D";
        String deurl2 = URLDecoder.decode(url2,"UTF-8");
        System.out.println(deurl2);

        String url3="%7B%22method%22%3A10020%7D";
        String deurl3 = URLDecoder.decode(url3,"UTF-8");
        System.out.println(deurl3);


        System.out.println("采用UTF-8字符集进行解码1111111111:");
        String keyWord = URLDecoder.decode("av=3.2b202106251611&wv=3.2_build190&fid=1471992819&core=gnGt9KfdL/uvGVWIs8R0GCM3SBk6zLs1wLuLjlERkTY=&sig=3faad43a880f47eb82766a08d634411d", "UTF-8");
        System.out.println(keyWord);
        System.out.println("采用UTF-8字符集进行解码:");
        String keyWord2 = URLDecoder.decode("fileId=1&jsonParams=%7B%22method%22%3A74%2C%22params%22%3A%7B%22fileId%22%3A%221%22%2C%22operId%22%3A%2210.214.92.209%243%22%7D%7D&_=1637825876635", "UTF-8");
        System.out.println(keyWord2);

        System.out.println("\n 采用GBK字符集进行解码:");
        System.out.println(URLDecoder.decode("%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6+Rico", "GBK"));

        System.out.println("\n 采用utf-8字符集:");
        String urlStr = URLEncoder.encode("天津大学", "utf-8");
        System.out.println(urlStr);
        System.out.println("\n 采用GBK字符集:");
        String urlStr2 = URLEncoder.encode("天津大学", "GBK");
        System.out.println(urlStr2);
    }

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    /*private static void quickSort(int[] a,int left,int right){
        if(left>=right)
            return ;
        int l=left;
        int r=right;
        int temp=a[l];

        while(l<r){
            while(r>l&&a[r]>=temp)
                r--;
            a[l]=a[r];
            while(r>l&&a[l]<=temp)
                l++;
            a[r--]=a[l];
        }
        a[l]=temp;

        //拆分
        quickSort(a,left,l-1);
        quickSort(a,l+1,right);
    }*/

    private static void quickSort(int[] a,int left,int right){
        if(left>=right)
            return;
        int l=left;//由于后面会更改left的值，这里暂存下
        int r=right;
        int temp=a[l];//temp就是基准数
        while(l<r){
            while(l<r&&a[r]>=temp)//顺序很重要，先从右往前找
                r--;
            a[l]=a[r];
            while(l<r&&a[l]<=temp)
                l++;
            a[r--]=a[l];
        }
        a[l]=temp;//用基准数覆盖左右哨兵相遇下标的值

        quickSort(a,left,l-1);//左序列递归快速排序
        quickSort(a,l+1,right);//右序列递归快速排序
    }
}
/*
*
* 1.刷算法题（重要，需要长时间的积累）
* 2.各种小知识点：各种排序算法，设计模式，sql优化，堆栈（这个属于数据结构）（好像也不算小）
* 3.框架（需要看视频教程，看教程也行不过看着有些累且有些不靠谱的跟着做但不一样的结果就很懵）
* 4.负载均衡，linux，数据库隔离级别，主从复制，索引类型，3次握手（这个属于网络方面的）
*
*
* 其实最最关键的，是持续学习的能力，每天坚持一点点，就能有质的改变。
* 我应该早早意识到这点，很多很多事情只能通过坚持下去，一点点来完成，没有其他捷径！
*
* 那么对于学习java来说，最最关键的点就出现了：持续学习。
* 如果我能保证每天学习一点点：
*   (1)假如从今天开始，每天刷一道算法题，1个月后我的算法能力可以明显提高，从现在的做中等题目全靠运气能否做得出来，到无论多难的题目也能至少有一些思路
*   (2)假如从今天开始，每两天搞懂一个排序算法，那么2周后我会熟悉常见的绝大多数排序算法，不至于在面试时支支吾吾
*   (3)假如从今天开始，每天学习1.5个小时springCloud，那么1个月后我将熟悉springCloud，能在简历上增光添彩
*   (4)假如从今天开始，限制自己玩游戏的时间到1个小时，那么每天至少可以多出来2个小时用来做更加有意义的事情，每个月就是60个小时
*   (5)假如从今天开始，每天锻炼身体半小时，那么1周后我会感觉身体状态变好了，1个月后可能体重减少5斤，半年后肚子不显得那么大了，1年后不再有啤酒肚。。。
* 这些事情有3个特征：1是一次性做的事情不需要太多，2是要求每天都要做，3是收益非常大
* 同时也有一个非常关键的点：一次性不能做太多，贪心会容易使人坚持不下去，特别是刚开始的时候。所以上面这几条，每条去看的确不多，但我不能每天把这5条都做一遍，太多，太贪心。
*
* 今天是6.16，周三，我想在接下来的一周内，每天做好以下几件事情：
* 1.每天刷一道算法题（力扣每日一题），根据困难程度时间在1-2h（最多不超过2h，超过2h不属于现在水平的我该看的），要求每天都要做
* 2.限制玩游戏时间在1h内
* 3.每天运动半小时
* 别的时间，则可以自己定义。
*
* 一周之后，总结这一周的收获，以及不足。
* */

