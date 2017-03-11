
import java.util.*;
import java.lang.*;
import java.io.*;

public class CS342VIDSort
{
	public static void main (String[] args)
	{
		/*
		 * GUI usage test
		 */
		int[] testArray = {37, 6, 21, 17, 30, 2, 14, 40, 9, 32, 39, 15};
		ViDSortGUI gui = ViDSortGUI.getInstance("ViDSort");
		gui.update(testArray); // display the array


		/*
		 *	SortArray/SortAlgorithm implementation test
		 */

		SortAlgorithm algorithm = new BubbleSort();
    	SortArray testVisualArray = new VisualArray(50, algorithm);

    	//prints array(unsorted)
    	for (int i = 0; i < testVisualArray.getSize(); i++) {
    		System.out.println(testVisualArray.array[i]);
    	}

    	algorithm.sort(testVisualArray);

    	//prints array(sorted)
    	for (int i = 0; i < testVisualArray.getSize(); i++) {
    		System.out.println(testVisualArray.array[i]);
    	}
	}
}
