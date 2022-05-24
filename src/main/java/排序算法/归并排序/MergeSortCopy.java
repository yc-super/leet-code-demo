package 排序算法.归并排序;

import java.util.Arrays;

public class MergeSortCopy {
    public static void main(String []args){
//        int []arr = {9,8,7,6,5,4,3,2,1};
        int []arr = {3,9,7,5,6,4,8,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left>=right)
            return;
        int middle=(left+right)/2;
        mergeSort(arr,left,middle,temp);
        mergeSort(arr,middle+1,right,temp);
        mergeSort(arr,left,middle,right,temp);
    }

    private static void mergeSort(int[] arr, int left, int middle, int right, int[] temp) {
        int l=left;//左序列指针
        int r=middle+1;//右序列指针
        int index=0;
        while(l<=middle&&r<=right){
            while(l<=middle&&arr[l]<=arr[r]){
                temp[index++]=arr[l++];
            }
            while(r<=right&&arr[l]>arr[r]){
                temp[index++]=arr[r++];
            }
        }
        while(l<=middle){
            temp[index++]=arr[l++];
        }
        while(r<=right){
            temp[index++]=arr[r++];
        }

        index=0;
        //将temp中的数据全部拷贝到arr
        while(left<=right)
            arr[left++]=temp[index++];
    }
}
