
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
		gui.updateVisualArray(testArray); // display the array
	}
}
