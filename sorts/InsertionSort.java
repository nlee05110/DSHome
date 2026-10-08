public class InsertionSort { 
	public static void main(String[] args){
		int[] array = {6,3,8,4,1,2,9,7,5};
		
		printArr(array);
		insertionSort(array);
		printArr(array);
	}

	public static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int j = i;
			int temp = arr[j];
			while(j > 0 && temp < arr[j-1]){
		
				if(temp < arr[j-1]){
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}			
			
				printArr(arr);
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
