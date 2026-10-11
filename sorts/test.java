package sorts;

public class test {
        public static void main(String[] args){
            int[] array = {2,7,3,6,4,10,1,9,8,5};
            printArray(array);
            quickSort(array, 0, array.length-1);
            printArray(array);
            
        }
        
        public static void quickSort(int[] array, int min, int max){
            if(min>=max) return;

            int pivot = partition(array, 0, max);
            quickSort(array, min, pivot-1);
            quickSort(array,pivot+1,max);

        }
        public static int partition(int[] array, int min, int max){
            int j = min;
            int i, temp;
            int pivot = array[max]; 
            for(i = min-1; j < max; j++){
                if(array[j] < pivot){
                    i++;
                    temp = array[j]; 
                    array[j] = array[i];
                    array[i] = temp;
                } 
            }  
            i++;
            temp = array[max];
            array[max] = array[i];
            array[i] = temp;
            return i;
        }
        public static void printArray(int[] array){
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

}

