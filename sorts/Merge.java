
package sorts;


public class Merge {
    
    public static void main(String[] args){
        int[] arr1 = {1,4,2,5,3};
        int[] arr2 = {7,6,8,9,10};
        int[] array = new int[arr1.length + arr2.length];
        


        System.out.println("Array 1 -------------------------");
        printArray(arr1);
        sort(arr1);
        System.out.println("Array 2 -------------------------");
        printArray(arr2);
        sort(arr2);
        
        System.out.println("Merged array -------------");
        mergeArray(arr1, arr2, array);
        printArray(array);
    }

    public static void sort(int[] arr){
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

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeArray(int[] arr1, int[] arr2, int[] mergeArray){
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
