import java.util.*;
import java.lang.*;
import java.io.*;

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
                    if (gui.getMode() == ViDSortGUI.Mode.COMPARISON_MODE) {     //create 2 threads to run both sorts simultaneously
                        Thread threadRight = new Thread() {
                            public void run() {
                                SortArray testVisualArray = new VisualArray(size, gui.getSelectedRightAlgorithm(), true);
                                testVisualArray.sort();
                            }
                        };

                        Thread threadLeft = new Thread() {
                            public void run() {
                                SortArray testVisualArray = new VisualArray(size, gui.getSelectedLeftAlgorithm(), false);
                                testVisualArray.sort();
                            }
                        };
                        
                        threadRight.start();
                        threadLeft.start();

                        try {
                            threadRight.join();
                            threadLeft.join();
                        }
                        catch (InterruptedException e) {
                            System.exit(-1);
                        }
                        
                    }
                    else {
                        SortArray testVisualArray = new VisualArray(size, gui.getSelectedRightAlgorithm(), true);
                        testVisualArray.sort();
                    }
                    
                    gui.toggleRunningSort();
                }
            }
        }, 0, 100);
	}
}
