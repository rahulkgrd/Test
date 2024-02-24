import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    // 8 3 6 8 5
    static int partition(int[] arr, int l, int r){
        if (l==r)
            return l;
        int pivot = arr[r];
        int i=l-1;
        for (int j=l;j<=r;j++){
            if (arr[j]<pivot){
                int tmp=arr[j];
                i++;
                arr[j]=arr[i];
                arr[i]=tmp;
            }
        }
        arr[r]=arr[++i];
        arr[i]=pivot;
        return i;
    }
    static void quickSort(int[] arr,int start,int end){
        if (start>=end)
            return;
        int partition=partition(arr, start, end);
        quickSort(arr,start,partition-1);
        quickSort(arr,partition,end);
    }
}
