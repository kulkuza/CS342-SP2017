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
		ViDSortGUI gui = ViDSortGUI.getInstance();
		gui.setDefaultSettings();
        
        Timer tt = new Timer();
        tt.schedule(new TimerTask() {
            @Override
            public void run() {
                if (gui.isRunningSort()) {
                    int size = gui.getSelectedSize();
                    SortArray testVisualArray = new VisualArray(size, gui.getSelectedRightAlgorithm());
                    
                    testVisualArray.sort();
                    
                    gui.toggleRunningSort();
                }
            }
        }, 0, 100);
	}
}
