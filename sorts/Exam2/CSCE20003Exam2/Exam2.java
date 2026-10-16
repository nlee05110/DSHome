package CSCE20003Exam2;


public class Exam2 {

	public static void main(String[] args) {
		int[] array= {100,90,80,70,60,50,40,30,20,10};
		int[] array1= {10,20,30,100,50,90,70,80,60,40};
		int[] array2= {10,20,30,40,50,60,70,80,90,100};
		int comparisons;
		
		showArray(array);
		comparisons=bubbleSort(array);
		showArray(array);
		System.out.printf("Comparisons: %d\n",comparisons);
		
		System.out.printf("----------------\n\n");
		
		showArray(array1);
		comparisons=bubbleSort(array1);
		showArray(array1);
		System.out.printf("Comparisons: %d\n",comparisons);
		
		System.out.printf("----------------\n\n");
		
		showArray(array2);
		comparisons=bubbleSort(array2);
		showArray(array2);
		System.out.printf("Comparisons: %d\n",comparisons);
		
	}
	
	public static void showArray(int[] array) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<array.length;index++) {
			if(index!=0) {
				System.out.printf(",");
			}
			System.out.printf("%d", array[index]);
		}
		System.out.printf("]\n");
	}
	
	public static int bubbleSort(int[] array) {
		int index,pass, temp;
		int comparisons=0;
		
		for(pass=0;pass<array.length-1;pass++) {
            if(array[pass]>array[pass+1]){
                
                for(index=0;index<array.length-1;index++) {
                    comparisons++;
                    if(array[index]>array[index+1]) {
                        temp=array[index];
                        array[index]=array[index+1];
                        array[index+1]=temp;
                    }
                }
                pass=-1;
            }
            showArray(array);
	    }
		
		return comparisons;
	}

}
