package 排序算法.快速排序;

public class QuickSort {
    public static void main(String[] args) {
        int[] array={3,5,21,565,2,9};
        quickSort(array,0,array.length-1);
        for(int i:array){
            System.out.println(i);
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left>=right)
            return;
        int l=left;
        int r=right;
        int temp=array[l];
        while(l<r){
            while (l<r&&array[r]>=temp)
                r--;
            array[l]=array[r];
            while (l<r&&array[l]<=temp)
                l++;
            array[r--]=array[l];
        }
        array[l]=temp;
        quickSort(array,left,l-1);
        quickSort(array,l+1,right);
    }


}
