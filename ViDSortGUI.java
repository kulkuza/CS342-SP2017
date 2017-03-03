/*
 * // Usage:
 * ViDSortGUI gui = ViDSortGUI.getInstance("Window Title Here");
 *
 * ...
 * 
 * gui.updateArray(arr); // draw representation of array
 */

public class ViDSortGUI {
	private static ViDSortGUI instance; // singleton

    private Window window;
    private UserControlMenu userControlMenu = new UserControlMenu();
    private ArrayCanvas arrayCanvas = new ArrayCanvas();
    
    private ViDSortGUI(String windowTitle) {
        window = new Window(windowTitle);
        window.addLeftPanel(userControlMenu);
        window.addRightPanel(arrayCanvas);
        window.revalidate();
    }
        
    private ViDSortGUI(int windowWidth, int windowHeight, String windowTitle) {
        window = new Window(windowWidth, windowHeight, windowTitle);
        window.addLeftPanel(userControlMenu);
        window.addRightPanel(arrayCanvas);
        window.revalidate();
    }

	public static ViDSortGUI getInstance(String windowTitle) {
		if (instance == null) {
			instance = new ViDSortGUI(windowTitle);
		}

		return instance;
	}

	public static ViDSortGUI getInstance(int windowWidth, int windowHeight, String windowTitle) {
		if (instance == null) {
			instance = new ViDSortGUI(windowWidth, windowHeight, windowTitle);
		}

		return instance;
	}
    
    public void updateArray(int[] arr) {
        arrayCanvas.drawArray(arr);
    }
}
