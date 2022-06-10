package 排序算法.冒泡排序;

public class MyCode {
    public static void main(String[] args) {
        int a[]={2,5,3,7,1};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    private static void bubbleSort(int[] a){
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length-i; j++) {
                if(a[j+1]<a[j]){
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    
    private void bubbleSort2(int[] a){
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length-i; j++) {
                if(a[j+1]<a[j]){
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
}
