package sorts;

public class Bubblesort{
    public static void main(String[] args){
        int[] array = {1,6,4,7,3,9,5,8,2};

        printArray(array);
        bubblesort(array); 
        printArray(array);
    }
    public static void bubblesort(int[] array){
        int temp;
        for(int i = 0; i < array.length; i++){
            int iteration = i+1;
            System.out.println("Iteration: " + iteration);
            for(int j = 0; j < array.length-1;j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                } 
                printArray(array);
            }
        }
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
}
