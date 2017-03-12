public class QuickSort externds SortAlgorithm{
	public QuickSort(){
		super("QuickSort");
	}
	
	public void sort(SortArray array){
		int size = array.getSize();
		int low = 0;
		int high = size - 1;
		
		quickSort(array, low, high);
	}

	public void quickSort(SortArray array, int lowIndex, int highIndex){
		//Check to see if array is empty
		if (array == null)
			return;
		
		//Since function is recursive, exit if both ends meet
		if(lowIndex >= highIndex)
			return;
		
		int midPoint = lowIndex + ((highIndex - lowIndex) / 2);
		
		//the element we are going to compare to in the array
		int pivot = array[midPoint];
		
		//Create variable to hold the first and last indexes in the array
		int i = lowIndex;
		int j = highIndex;
		
		//both ends will move towards the middle and stop if they meet
		//or if the element they're on is on the right of the pivot and <pivot
		//or if the element is on the left of the pivot and it is >pivot
		while (i <= j){
			while (array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			
			if (i <= j){
				array.compareAndSwap(i,j);
				i++;
				j--;
			}
		}
		
		//If there are still more elements to check in the left half
		//of the array, call function again. Same for the right half.
		if (lowIndex < j)
			quickSort(array, lowIndex, j);
		if (highIndex > i)
			quickSort(array, i, highIndex);
	}
}