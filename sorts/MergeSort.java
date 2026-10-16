package sorts;

public class MergeSort{

    public static void main(String args[])
    {

        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};

        mergeSort(array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }

    private static void mergeSort(int[] array) {
        

        int length = array.length;
        if (length <= 1) return; 

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; 
        int j = 0;

        for(; i < length; i++) {
            if(i < middle) {
                leftArray[i] = array[i];
            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        mergeArrays(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) { //while loop variation

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; 

        while(l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static void mergeArrays(int[] leftArray, int[] rightArray, int[] array){ //for loop variation
        int temp;
        int l=0, r=0;
        int i = 0;
        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        for(; l < leftSize && r < rightSize; i++){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                l++;
            } else if(leftArray[l] > rightArray[r]){
                array[i] = rightArray[r];
                r++;
            }
        }

        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }  
    }
}
