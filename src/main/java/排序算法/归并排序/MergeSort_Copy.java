package 排序算法.归并排序;

import java.util.Arrays;

public class MergeSort_Copy {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp=new int[arr.length];
        merge(arr,0,arr.length-1,temp);
    }

    private static void merge(int[] arr, int left, int right, int[] temp) {
        if(left<right){
            int middle=(left+right)/2;
            merge(arr,left,middle,temp);//左边递归排序使得左边有序
            merge(arr,middle+1,right,temp);//右边递归排序，使得右边有序
            mergeSort(arr,left,middle,right,temp);//左右合并
        }
    }

    private static void mergeSort(int[] arr, int left, int middle, int right, int[] temp) {
        int l=left;//左序列指针
        int r=middle+1;//右序列指针
        int t=0;//临时数组指针

        while(l<=middle&&r<=right){
            if(arr[l]<=arr[r]){
                temp[t++]=arr[l++];
            }else{
                temp[t++]=arr[r++];
            }
        }

        while(l<=middle){
            temp[t++]=arr[l++];
        }
        while(r<=right){
            temp[t++]=arr[r++];
        }

        t=0;
        while(left<=right){
            arr[left++]=temp[t++];//将temp中的元素全部拷贝到元素组中
        }

    }
}
