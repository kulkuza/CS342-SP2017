
import java.util.*;
import java.lang.*;
import java.io.*;

/*
 *	TODO: -fully implement textbox for array creation 
 *			and dropdown menu for algorithm selection
 *		  -Send data from the VisualArray to the GUI to get updated
 *
 *	Steps when start button is pressed:
 *		1) The size is saved from the textbox as an int.
 *		2) An instance of SortAlgorithm is created depending on dropmenu selection
 *			a) For example, if bubblesort was selected, then
 *				SortAlgorithm algorithm = new BubbleSort();
 *		3) An instance of the SortArray is created with the info from 1) and 2)
 *			a) For example,
 *				SortArray newArray = new VisualArray(size, algorithm)
 *
 */

public class CS342VIDSort
{
	public static void main (String[] args)
	{
		/*
		 * GUI usage test
		 */
		int[] testArray = {37, 6, 21, 17, 30, 2, 14, 40, 9, 32, 39, 15};
		ViDSortGUI gui = ViDSortGUI.getInstance();
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
