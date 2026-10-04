public class Insertionsort { 
	public static void main(String[] args){
		int[] array = {6,3,8,4,1,2,9,7,5};
		
		printArr(array);
		insertionSort(array);
		printArr(array);
	}

	public static void insertionSort(int[] arr){
		int temp;
		for(int i = 1; i < arr.length; i++){
			int j = i-1;
			temp = arr[i];
			while(j>=0 && temp < arr[j]){
			
				printArr(arr);
				arr[i] = arr[j];
				arr[j] = temp;
				temp = arr[j];
				j--;
			}
		}

	}
	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");

		}
		System.out.println();


	}



} 
