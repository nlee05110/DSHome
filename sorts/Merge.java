package sorts;


public class Merge {
    
    public static void main(String[] args){
        int[] arr1 = {1,4,2,5,3};
        int[] arr2 = {7,6,8,9,10};
        int[] array = new int[arr1.length + arr2.length];
        
        mergeArrays(arr1, arr2, array);
        printArray(array);
        
        mergeSort(array);
        printArray(array);
    }

    public static void insertionsort(int[] arr){
        printArray(arr); 
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            int j = i; 
            while(j > 0){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }  
                j--;
            }
            
            printArray(arr); 
        }
    }
    
    public static void mergeSort(int[] array){
        int length = array.length;
        int middle = length/2;

        if(length <= 1) return;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];
        
        int i = 0;
        int j = 0;
        for(; i<array.length; i++){
            if(i < middle){
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray, rightArray); 
        
        
       

    }
    public static void merge(int[] array, int[] leftArray, int[] rightArray){
        int i = 0;
        int l = 0;
        int r = 0;
        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeArrays(int[] arr1, int[] arr2, int[] mergeArray){
        int j = 0;
        for(int i = 0; i < mergeArray.length; i++){
            if(i < mergeArray.length/2){
                mergeArray[i] = arr1[i];
            } else {
                mergeArray[i] = arr2[j];
                j++;
            }
            
        }
    }

}
