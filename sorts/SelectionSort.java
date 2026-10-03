public class SelectionSort{

	public static void main(String[] args){
		
		int[] array = {3,6,2,7,1,9,4,8,5};
		
		System.out.print("The contents of the array are -> ");
		printArr(array);
		selectionSort(array);
		printArr(array);

	}
	
	public static void selectionSort(int[] arr){
		int temp;
		int index = 0; 
		for(int i=0; i < arr.length-1; i++){
			int min = arr[i];
			for(int j = i; j < arr.length; j++){
				if(min > arr[j]){
					index = j;
					min = arr[j];
				}
			}

			if(min == arr[index]){
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
			printArr(arr);
			

		}


	}

	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
