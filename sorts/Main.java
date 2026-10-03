package sorts;
public class Main {
    public static void main(String[] args) {
        int[] array = {3,5,7,9,4,2,8,1,6};
        // 5,3,
        quickSort(array, 0, array.length-1);
        printArr(array);
    }
    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;
        int pivot  = partition(arr, start, end);
        System.out.println("pivot: " + arr[pivot]);
        printArr(arr);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
    public static int partition(int[] arr, int start, int end){
        int i = start-1;
        int pivot = arr[end];

        for( int j = start; j <= end-1; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
